package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10997 {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        if (num == 1) {
            System.out.println("*");
            return;
        }

        int rSize = num * 4 - 1;
        int cSize = num * 4 - 3;

        map = new int[rSize][cSize];

        // 3개의 변 먼저 그리기
        for (int i = 0; i < map[i].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
        }


        star(map.length - 1, map[0].length - 1, 0, rSize - 2, cSize - 2);

        // 맵에 들어있는 값들을 스트링빌더에 추가
        for (int i = 0; i < map.length; i++) {
            if (i == 1) {
                sb.append("*").append("\n");
                continue;
            }
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }



    static void star(int r, int c, int direction, int rSize, int cSize) {
        if (rSize == 1 && cSize == 1) return;

        if (direction > 3) {
            direction = 0;
        }

        
        
        // 가로방향 세로방향으로 그릴때 구분하기
        if (direction % 2 == 0) {
            for (int i = 0; i < rSize; i++) {
                map[r+ dx[direction] * i][c] = 1;
            } 
            r = r + (rSize - 1) * dx[direction];
            star(r, c, direction + 1, rSize - 2, cSize);
        } else {
            for (int i = 0; i < cSize; i++) {
                map[r][c + dy[direction] * i] = 1;
            } 
            c = c + (cSize - 1) * dy[direction];
            star(r, c, direction + 1, rSize, cSize - 2);
        }
        
        
    }

}
