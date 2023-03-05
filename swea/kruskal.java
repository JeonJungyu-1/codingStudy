package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kruskal {
    static int T, V, E;
    static StringBuilder sb;
    static PriorityQueue<Edge> edgeList;
    static int[] p, r;
    static long min;

    
    static class Edge implements Comparable<Edge> {
        int s, e;
        long w;

        public Edge(int s, int e, long w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }

        
        
    }
    public static void main(String[] args) throws IOException {
        init();

    }
    private static void solve() {

        makeSet();
        int cnt = 0;
        min = 0;
        while (cnt != V - 1) {
            Edge edge = edgeList.poll();
            if (union(edge.s, edge.e)) {
                min += edge.w;
                cnt++;
            }
        }

    }
    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        if (r[x] > r[y]) {
            p[y] = x;
            r[x] += r[y];
        } else {
            p[x] = y;
            r[y] += r[x];
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
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new PriorityQueue<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());
                edgeList.offer(new Edge(s, e, w));
            }
            solve();
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
}
