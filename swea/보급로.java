package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 보급로 {
    static int T, N;
    static int[][] map;
    static StringBuilder sb;
    static PriorityQueue<Edge> pq;
    static int[][] distance;
    static boolean[][] checked;
    static final int INF = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

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
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            distance = new int[N][N];
            checked = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = ch[j] - '0';
                }
            }
            pq = new PriorityQueue<>();

            solve();


            sb.append("#").append(t).append(" ").append(distance[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solve() {

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
        }
        pq.offer(new Edge(0, 0, map[0][0]));
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
}
