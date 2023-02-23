import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 절약할 수 있는 최대비용 구하는거
// 총비용 - 최소비용을 빼주면 됨
public class Main {
    static int totalPrice;
    static int V, E;
    static PriorityQueue<Edge> pq;
    static int[] p, r;

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
    public static void main(String[] args) throws IOException {
        init();
    }
    private static void solve() {
        makeSet();
        int cnt = 0;
        int min = 0;
        while (cnt != V - 1) {
            Edge edge = pq.poll();
            if (union(edge.s, edge.e)) {
                min += edge.w;
                cnt++;
            }
        }
        totalPrice -= min;
    }
    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        if (r[px] > r[py]) {
            p[py] = px;
            r[px] += r[y];
        } else {
            p[px] = py;
            r[py] += r[x];
        }


        return true;
    }
    private static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }
    private static void makeSet() {
        p = new int[V + 1];
        r = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if (V == 0 && E == 0) break;
            pq = new PriorityQueue<>();
            totalPrice = 0;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                totalPrice += w;
                pq.offer(new Edge(s, e, w));
            }
            solve();
            sb.append(totalPrice).append("\n");
        }
        System.out.println(sb.toString());

    }
}