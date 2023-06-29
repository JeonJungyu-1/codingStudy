import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 알고리즘 수업 - 깊이 우선 탐색 1
// dfs

public class Main {
    
    static StringBuilder sb;
    static List<List<Integer>> adj;
    static int N, M, R;
    static boolean[] visited;
    static int[] count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int i = 1; i <= N; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        dfs(R);
        print();
    }

    private static void dfs(int r) {
        visited[r] = true;
        count[r] = ++count[0];

        for (int next : adj.get(r)) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        

        visited = new boolean[N + 1];
        count = new int[N + 1];


    }
}