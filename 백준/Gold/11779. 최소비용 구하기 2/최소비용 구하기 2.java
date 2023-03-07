import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기 2
// 다익스트라

public class Main {
    static StringBuilder sb;
    static int V, E;
    static PriorityQueue<Edge> pq;
    static int[] distance;
    static boolean[] checked;
    static int start, end;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge>[] adj;
    static int[] cityList;

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
        int index = cityList[end];
        List<Integer> bufferList = new ArrayList<>();
        bufferList.add(end);
        while (true) {
            bufferList.add(index);
            if (index == start) break;
            index = cityList[index];
        }
        sb.append(distance[end]).append("\n").append(bufferList.size()).append("\n");
        for (int i = bufferList.size() - 1; i >= 0; i--) {
            sb.append(bufferList.get(i)).append(" ");
        }

        
        System.out.println(sb.toString());
    }

    private static void solve() {
        dijkstra();
    }

    private static void dijkstra() {
        Arrays.fill(distance, INF);
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (checked[cur.v]) continue;
            checked[cur.v] = true;

            for (Edge next: adj[cur.v]) {
                if (checked[next.v]) continue;
                if (distance[next.v] > distance[cur.v] + next.w) {
                    distance[next.v] = distance[cur.v] + next.w;

                    cityList[next.v] = cur.v;

                    pq.offer(new Edge(next.v, distance[next.v]));
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        distance = new int[V + 1];
        checked = new boolean[V + 1];
        cityList = new int[V + 1];
        adj = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adj[i] = new ArrayList<>();
        }
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