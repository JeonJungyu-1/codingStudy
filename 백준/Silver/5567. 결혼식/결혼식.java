import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 결혼식

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();



        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited = new boolean[n + 1];

        bfs(adj, visited);

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) cnt++;
        }

        System.out.println(cnt - 1);


    }


    private static void bfs(List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
    
                if (visited[cur]) continue;
                visited[cur] = true;
                
                if (cnt >= 2) continue;
                for (int next : adj.get(cur)) {
                    que.offer(next);
                }
            }
            cnt++;

        }

    }
}