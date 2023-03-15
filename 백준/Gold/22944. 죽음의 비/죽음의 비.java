import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 죽음의 비

public class Main {
    static int N, H, D;
    static int[][] map;
    static int[][] visited;
    static Node start, end;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int min;
    static class Node {
        int r, c, h, u, d;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int h, int u, int d) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.u = u;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node [r=" + r + ", c=" + c + ", h=" + h + ", u=" + u + ", d=" + d + "]";
        }

        
        
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        explore();
    }

    private static void explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(start.r, start.c, start.h, start.u, 0));
        visited[start.r][start.c] = start.u + start.h;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc)) continue;
                if (nr == end.r && nc == end.c) {
                    min = cur.d + 1;
                    return;
                }  

                int nu = cur.u;
                int nh = cur.h;

                // 우산을 만났을때
                if (map[nr][nc] == 5) {
                    nu = D;
                }
                
                
                // 우산이 남아 있다면
                if (nu > 0) {
                    nu--;
                } else {
                    nh--;
                }
                
                // 체력이 0인경우 죽음
                if (nh == 0) {
                    min = -1;
                    continue;
                }
                if (visited[nr][nc] >= (nu + nh)) continue;
                que.offer(new Node(nr, nc, nh, nu, cur.d + 1));
                visited[nr][nc] = nu + nh;
            }
        }
        

    }
    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (ch[j] == '.') {
                    map[i][j] = 0;
                } else if (ch[j] == 'S') {
                    start = new Node(i, j, H, 0, 0);
                } else if (ch[j] == 'E') {
                    end = new Node(i, j);
                } else if (ch[j] == 'U') {
                    map[i][j] = 5;
                }
            }
        }

    }
}