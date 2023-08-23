import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 너구리 구구

public class Main {
    
    static StringBuilder sb;

    static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        
        int N = Integer.parseInt(br.readLine());
        List<List<Edge>> list = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Edge(to, cost));
            list.get(to).add(new Edge(from, cost));
        }

        long[] max = new long[1];
        max[0] = Long.MIN_VALUE;

    
        visited[1] = true;
        dfs(1, 0, max, list, visited);

        System.out.println(max[0]);

    }



    private static void dfs(int cur, long sum, long[] max, List<List<Edge>> list, boolean[] visited) {
        max[0] = Math.max(max[0], sum);

        for (Edge edge : list.get(cur)) {
            if (visited[edge.v]) continue;
            visited[edge.v]  = true;
            dfs(edge.v, sum + edge.w, max, list, visited);
            visited[edge.v]  = false;
        }
    }
}