import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] distance;
    static int V, E, K;
    static PriorityQueue<Edge> pq;

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

    static List<Edge>[] adj;
    static int MM = Integer.MAX_VALUE/1000;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s - 1].add(new Edge(e - 1, w));
        }
        distance = new int[V];
        Arrays.fill(distance, MM);
        checked = new boolean[V];

        distance[K - 1] = 0;
        pq.offer(new Edge(K - 1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (checked[edge.v]) continue;
            checked[edge.v] = true;

            for (Edge next: adj[edge.v]) {
                if (!checked[next.v] && distance[next.v] > distance[edge.v] + next.w) {
                    distance[next.v] = distance[edge.v] + next.w;
                    pq.offer(new Edge(next.v, distance[next.v]));
                }
            }
        }

        // for (int i = 0; i < V - 1; i++) {
        //     int minV = MM;
        //     int w = -1;
        //     for (int j = 0; j < V; j++) {
        //         if (!checked[j] && minV > distance[j]) {
        //             minV = distance[j];
        //             w = j;
        //         }
        //     }

        //     if (w == -1) break; // 끊어짐
        //     checked[w] = true;

            
        // }

        StringBuilder sb = new StringBuilder();
        for (int d : distance) {
            if (d != MM) {
                sb.append(d).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb.toString());

    }


}