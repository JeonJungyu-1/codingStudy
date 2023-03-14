import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
// bfs

public class Main {
    static StringBuilder sb;
    static int T, N;
    static int[][] map;
    static Node start, end;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Node {
        int r, c, move;

        public Node(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            int cnt = 0;
            if (start.r != end.r || start.c != end.c) {
                cnt = bfs();
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    


    private static int bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(start);
        map[start.r][start.c] = 1;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr == end.r && nc == end.c) return cur.move + 1;

                if (!isInRange(nr, nc) || map[nr][nc] == 1) continue;
                que.offer(new Node(nr, nc, cur.move + 1));
                map[nr][nc] = 1;
            }
        }

        return -1;


    }


    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    
}