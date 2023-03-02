import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] checked;
    static int[][] map;
    static PriorityQueue<Edge> pq;
    static int[][] distance;
    static final int INF = Integer.MAX_VALUE / 1000;
    static StringBuilder sb;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
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
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
    }

    private static void solve() {
        pq.offer(new Edge(0, 0, map[0][0]));
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
        }
        distance[0][0] = map[0][0];

        while (!pq.isEmpty()) {
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
        return r >= 0 && r < N && c >= 0 && c < N;
    }

 

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            checked = new boolean[N][N];
            map = new int[N][N];
            pq = new PriorityQueue<>();
            distance = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            sb.append("Problem ").append(cnt).append(": ").append(distance[N - 1][N - 1]).append("\n");
            cnt++;
        }
        System.out.println(sb.toString());
    }
}