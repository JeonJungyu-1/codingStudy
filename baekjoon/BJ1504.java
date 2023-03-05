package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로

public class BJ1504 {
    static StringBuilder sb;
    static ArrayList<Edge>[] adj;
    static int V, E;
    static int[] distanceA, distanceB;
    static boolean[] checked;
    static int[] mustPassV;
    static PriorityQueue<Edge> pq;
    static final int INF = Integer.MAX_VALUE / 1000;
    static int minDistance;

    

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
        System.out.println(minDistance);
    }

    private static void solve() {

        // 1번 정점부터 주어진 두 정점까지의 거리 + 두 정점 사이의 거리 + 두 정점부터 N번 정점까지의 거리
        makeSet();
        exploreMinDistance(mustPassV[0], distanceA);
        if (!isReachable()) return;
        
        makeSet();
        exploreMinDistance(mustPassV[1], distanceB);

        minDistance = Math.min(distanceA[1] + distanceA[mustPassV[1]] + distanceB[V], distanceB[1] + distanceB[mustPassV[0]] + distanceA[V]);
        
    }

    private static boolean isReachable() {
        if (distanceA[V] == INF || distanceA[1] == INF || distanceA[mustPassV[1]] == INF) {
            minDistance = -1;
            return false;
        }
        return true;
    }

    private static void exploreMinDistance(int start, int[] distance) {
        pq.clear();
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

    private static void makeSet() {
        checked = new boolean[V + 1];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

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
            adj[e].add(new Edge(s, w));
        }

        mustPassV = new int[2];
        st = new StringTokenizer(br.readLine());
        mustPassV[0] = Integer.parseInt(st.nextToken());
        mustPassV[1] = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();


        distanceA = new int[V + 1];
        Arrays.fill(distanceA, INF);
        distanceB = new int[V + 1];
        Arrays.fill(distanceB, INF);
        


    }
}
