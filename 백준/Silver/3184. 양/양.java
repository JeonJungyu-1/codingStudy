import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 양
// BFS

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int aliveWolf;
    static int aliveSheep;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        sb.append(aliveSheep).append(" ").append(aliveWolf);
        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 || visited[i][j]) continue;
                bfs(i, j); 
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));
        visited[r][c] = true;
        
        int wolf = 0;
        int sheep = 0;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (map[cur.r][cur.c] == 2) {
                sheep++;
            } else if (map[cur.r][cur.c] == 3) {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || map[nr][nc] == 1 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                que.offer(new Node(nr, nc));
            }

        }

        if (sheep > wolf) {
            aliveSheep += sheep;
        } else {
            aliveWolf += wolf;
        }



    }



    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == '.') {
                    map[i][j] = 0;
                } else if (ch[j] == '#') {
                    map[i][j] = 1;
                } else if (ch[j] == 'o') {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
        }



    }
}