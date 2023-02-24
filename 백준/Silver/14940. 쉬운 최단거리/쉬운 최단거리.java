import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {   
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static Node start;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static class Node {
        int r;
        int c;
        int distance;
        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
        
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        map[start.r][start.c] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!isVisited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(" ");

                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void solve() {
        bfs();
    }

    private static void bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(start.r, start.c, start.distance));
        isVisited[start.r][start.c] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] != 1 || isVisited[nr][nc]) continue;
                que.offer(new Node(nr, nc, node.distance + 1));
                map[nr][nc] = node.distance + 1;
                isVisited[nr][nc] = true;
            }


        }
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Node(i, j, 0);
                }
            }
        }


    }
}