import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 뿌요뿌요 - 구현, bfs
// 1. 초기맵상태에서 뿌요 탐색하기
// 2. 한번에 터트릴 수 있는 뿌요를 찾아서 모두 터트림
// 3. 그 후 뿌요들을 아래로 내려서 재배치
// 4. 더 이상 터트릴 수 있는 뿌요가 없을때까지 반복
public class Main {
    static StringBuilder sb;
    static char[][] map;
    static boolean[][] isVisited;
    static int chainCount;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static boolean isEnd;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        // for (int i = 0; i < 12; i++) {
        //     for (int j = 0; j < 6; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(chainCount - 1);
    }

    private static void solve() {
        while (true) {
            if (isEnd) break;
            isEnd = true;
            chainCount++;
            isVisited = new boolean[12][6];
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        bfs(i, j, map[i][j]);
                    }
                }
            }

            mapRelocation();
        }
    }

    private static void mapRelocation() {
        for (int j = 0; j < 6; j++) {
            int count = 0;
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') {
                    count++;
                } else if (map[i][j] != '.' && count > 0) {
                    map[i + count][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
    }

    private static void bfs(int r, int c, char color) {
        Queue<Node> que = new ArrayDeque<>();
        Queue<Node> puyo = new ArrayDeque<>();
        que.add(new Node(r, c, color));
        puyo.add(new Node(r, c, color));
        isVisited[r][c] = true;

        // 받아온 색상의 뿌요가 4개이상 연결되어 있는지
        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] != node.color || isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                que.add(new Node(nr, nc, map[nr][nc]));
                puyo.add(new Node(nr, nc, map[nr][nc]));
            }
        }

        removePuyo(puyo);
    }
    
    // 4개이상 연결되어 있다면 뿌요 삭제하기
    private static void removePuyo(Queue<Node> puyo) {
        if (puyo.size() >= 4) {
            while (!puyo.isEmpty()) {
                Node node = puyo.poll();
                map[node.r][node.c] = '.';
            }
            isEnd = false;
        }
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }

    static class Node {
        int r;
        int c;
        char color;
        public Node(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
        
        
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                map[i][j] = ch[j];
            }
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}