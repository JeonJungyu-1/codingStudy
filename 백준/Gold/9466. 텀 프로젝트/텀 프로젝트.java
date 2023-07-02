import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 텀 프로젝트
// dfs

public class Main {
    
    static StringBuilder sb;
    static int T;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] team = new int[N + 1];
            int[] adj = new int[N + 1];
            boolean[] visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                adj[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i <= N; i++) {
                if (team[i] != 0) continue;
                team[i] = i;
                dfs(i, adj, team, visited, i);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) cnt++;
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());



    }

    private static void dfs(int i, int[] adj, int[] team, boolean[] visited, int start) {
        
        if (team[adj[i]] != 0) {
            if (team[adj[i]] == start) {
                int s = adj[i];

                 while (true) {
                    visited[s] = true;
                    if (adj[i] == adj[s]) break;
                    s = adj[s];
                }
            }
            return;
        }

        team[adj[i]] = start;
        dfs(adj[i], adj, team, visited, start);

    }
}