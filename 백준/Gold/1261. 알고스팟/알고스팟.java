import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static PriorityQueue<Edge> pq;
    static int[][] distance;
    static boolean[][] checked;
    static final int INF = Integer.MAX_VALUE / 1000;
    static class Edge implements Comparable<Edge> {
        int r, c, w;

        public Edge(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(distance[N - 1][M - 1]);
    }
    private static void solve() {
        pq.offer(new Edge(0, 0, map[0][0]));
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
        }
        distance[0][0] = map[0][0];
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (checked[cur.r][cur.c]) continue;
            checked[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!mapCheck(nr, nc) || checked[nr][nc]) continue;
                if (distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
                    distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc];
                    pq.offer(new Edge(nr, nc, distance[nr][nc]));
                }
            }
        }

    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        map = new int[N][M];
        distance = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }
    }
}