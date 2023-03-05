import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기
// 다익스트라

public class Main {
    static StringBuilder sb;
    static int V, E;
    static int start, end;
    static ArrayList<Edge>[] adj;
    static PriorityQueue<Edge> pq;
    static int[] distance;
    static boolean[] checked;
    static final int INF = Integer.MAX_VALUE;

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
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(distance[end]);
    }

    private static void solve() {
        dijkstra();
    }

    private static void dijkstra() {
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (checked[cur.v]) continue;
            checked[cur.v] = true;

            for (Edge next : adj[cur.v]) {
                if (checked[next.v]) continue;
                if (distance[next.v] > distance[cur.v] + next.w) {
                    distance[next.v] = distance[cur.v] + next.w;
                    pq.offer(new Edge(next.v, distance[next.v]));
                }
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        checked = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, INF);
        pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

   

    }
}