import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static List<ArrayList<Integer>> adj;
    static boolean[] isVisited;
    static int cnt;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        print();

    }
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            dfs(i);
        }
        sb.append(cnt).append("\n");
    }

    private static void dfs(int s) {
        List<Integer> li = adj.get(s);
        for (int i = 0; i < li.size(); i++) {
            if (isVisited[li.get(i)]) continue;
            isVisited[li.get(i)] = true;
            dfs(li.get(i));
            cnt++;
        }
    }
    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            adj = new ArrayList<>();
            isVisited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adj.get(s).add(e);
                adj.get(e).add(s);
            }
            solve();

        }
        

    }
}