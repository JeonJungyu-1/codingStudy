import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프왕 쩰리 (Large)
// bfs

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static boolean[][] visited;
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
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs();
        System.out.println(result ? "HaruHaru" : "Hing");


    }

    private static boolean bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(0, 0));

        boolean isArrive = false;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.r == N - 1 && cur.c == N - 1) {
                isArrive = true;
                break;
            }

            if (visited[cur.r][cur.c]  || map[cur.r][cur.c] == 0) continue;
            visited[cur.r][cur.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + (dr[i] * map[cur.r][cur.c]);
                int nc = cur.c + (dc[i] * map[cur.r][cur.c]);
                if (!isInRange(nr, nc)) continue;
                que.offer(new Node(nr, nc));
            }
        }

        return isArrive;
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}