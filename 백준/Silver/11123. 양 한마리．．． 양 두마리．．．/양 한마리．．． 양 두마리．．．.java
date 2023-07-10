import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 양 한마리... 양 두마리...
// bfs

public class Main {
    
    static StringBuilder sb;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = ch[j] == '#' ? 1 : 0;
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || map[i][j] == 0) continue;
                    bfs(i, j, map, visited);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");


        }

        System.out.println(sb.toString());
    }


    private static void bfs(int r, int c, int[][] map, boolean[][] visited) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;


            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc, map.length, map[0].length) || map[nr][nc] == 0) continue;
                que.offer(new Node(nr, nc));
            }

        }

    }


    private static boolean isInRange(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}