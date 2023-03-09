import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
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
        System.out.println(distance[V]);
    }
    private static void solve() {
        dijkstra();
    }
    private static void dijkstra() {
        Arrays.fill(distance, INF);
        pq.offer(new Edge(1, 0));
        distance[1] = 0;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
            adj[e].add(new Edge(s, w));
        }


        distance = new int[V + 1];
        checked = new boolean[V + 1];
        pq = new PriorityQueue<>();
    }
}