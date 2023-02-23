import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] r;
    static int[] p;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

        
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
    }
    private static void solve() {
        makeset();
        
        int cnt = 0;
        int min = 0;
        while (cnt != V - 1) {
            Edge edge = pq.poll();
            
            if (union(edge.s, edge.e)) {
                cnt++;
                min += edge.w;
            }
        }

        System.out.println(min);
    }
    private static boolean union(int s, int e) {
        int px = find(s);
        int py = find(e);
        if (px == py) return false;

        if (r[px] > r[py]) {
            p[py] = px;
            r[px] += r[py];
        } else {
            p[px] = py;
            r[py] += r[px];
        }

        return true;
    }
    private static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }
    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        StringTokenizer st;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, w));
        }

    }
    private static void makeset() {
        p = new int[V + 1];
        r = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }   
}