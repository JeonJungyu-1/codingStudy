import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 상범빌딩 - bfs
public class Main {
    static int N, M, H;
    static int[][][] map;
    static boolean[][][] isVisited;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, -1, 0, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static Node startNode;
    static int minTime;

    public static void main(String[] args) throws IOException {
        init();
        solve();

    }

    private static void solve() {

        explore();
    }

    private static void print(StringBuilder sb) {
        if (minTime != -1) {
            sb.append("Escaped in ").append(minTime).append(" minute(s).").append("\n");
        } else {
            sb.append("Trapped!").append("\n");
        }
    }

    private static void explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.add(startNode);
        isVisited[startNode.r][startNode.c][startNode.h] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (map[node.r][node.c][node.h] == 2) {
                minTime = node.time;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                int nh = node.h + dh[i];

                if (!mapCheck(nr, nc, nh) || isVisited[nr][nc][nh] || map[nr][nc][nh] == 1) continue;
                que.add(new Node(nr, nc, nh, node.time + 1));
                isVisited[nr][nc][nh] = true;

            }
        }



    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            minTime = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0 && H == 0) {
                break;
            }
            map = new int[N][M][H];
            isVisited = new boolean[N][M][H];
    
            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    char[] ch = br.readLine().toCharArray();
                    for (int j = 0; j < M; j++) {
                        if (ch[j] == 'S') {
                            map[i][j][k] = 0;
                            startNode = new Node(i, j, k, 0);
                        } else if (ch[j] == '.') {
                            map[i][j][k] = 0;
                        } else if (ch[j] == '#') {
                            map[i][j][k] = 1;
                        } else {
                            map[i][j][k] = 2;
                        }
                    }
                }
                br.readLine();
            }
            solve();
            print(sb);
        }
        System.out.println(sb.toString());
    }

    private static boolean mapCheck(int r, int c, int h) {
        return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
    }

    static class Node {
        int r;
        int c;
        int h;
        int time;
        public Node(int r, int c, int h, int time) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.time = time;
        }
        
    }

    
}