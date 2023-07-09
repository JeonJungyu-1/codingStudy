import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 나무 탈출
// dfs

public class Main {
    
    static StringBuilder sb;
    static int count, N;
    static List<List<Integer>> adj;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        dfs(0, 1);

        System.out.println(count % 2 == 0 ? "No" : "Yes");

    }


    private static void dfs(int cnt, int cur) {
        visited[cur] = true;


        

        boolean isEnd = true;
        for (int next : adj.get(cur)) {
            if (visited[next]) continue;
            dfs(cnt + 1, next);
            isEnd = false;
        }

        if (isEnd) count += cnt;


    }
}