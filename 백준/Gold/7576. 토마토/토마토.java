import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int day = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        Queue<Coordinate> queue = new LinkedList<>();

        //맵 생성
        map = new int[Integer.parseInt(mapSize[1])][Integer.parseInt(mapSize[0])];
        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        //최초 익은 과일 큐에 삽입
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Coordinate(i, j, 0));
                }
            }
        }



        while (!queue.isEmpty()) {
            Coordinate coordi = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (!indexCheck(coordi.x + dx[i], coordi.y + dy[i]) && (map[coordi.x + dx[i]][coordi.y + dy[i]] == 0)) {
                    queue.offer(new Coordinate(coordi.x + dx[i], coordi.y + dy[i], coordi.day + 1));
                    map[coordi.x + dx[i]][coordi.y + dy[i]] = 1;
                }
            }
            day = coordi.day;
        }


        if (!checkZero()) {
            day = -1;
        }

        System.out.println(day);

    }

    
    // 좌표 클래스
    public static class Coordinate {
        public int x;
        public int y;
        public int day;

        public Coordinate() {
            super();
        }

        public Coordinate(int x, int y, int day) {
            super();
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static boolean checkZero() {
        int zeroCheck = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    zeroCheck++;
                }
            }
        }
        
        if (zeroCheck > 0) {
            return false;
        }
        return true;
    }

    static boolean indexCheck(int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[1].length;
    }
}
