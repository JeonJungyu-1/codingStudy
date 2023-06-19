import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 파티
// 다익스트라

public class Main {
    
    static StringBuilder sb;

    static int N, M, X;

    static int INF = Integer.MAX_VALUE;
    static List<List<Edge>> adj;
    static int[][] distance;
    static boolean[] checked;
    static Queue<Edge> pq;



    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Edge(e, w));
        }

        distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance[i], INF);
        }

        for (int i = 1; i <= N; i++) {
            pq = new PriorityQueue<>();
            checked = new boolean[N + 1];
            distance[i][i] = 0;
            pq.offer(new Edge(i, 0));

            while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                if (checked[cur.v]) continue;
                checked[cur.v] = true;

                for (Edge next: adj.get(cur.v)) {
                    if (distance[i][next.v] > distance[i][cur.v] + next.w) {
                        distance[i][next.v] = distance[i][cur.v] + next.w;
                        pq.offer(new Edge(next.v, distance[i][next.v]));
                    }
                }
            }

        }


        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, distance[i][X] + distance[X][i]);
        }

        System.out.println(result);
        



    }
}