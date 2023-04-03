import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

// 플로이드 2

public class Main {
    static int n, m;
    static int[][] dp;
    static int[][] route;
    static final int INF = 100001;
    static StringBuilder sb;
    static Deque<Integer> deque;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        route = new int[n + 1][n + 1];
        deque = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (dp[s][e] == 0 || dp[s][e] > w) {
                dp[s][e] = w;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && dp[i][j] == 0) {
                    dp[i][j] = INF;
                }
            }
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                        route[i][j] = k;
                    }
                    
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dp[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }


        


        for  (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || dp[i][j] == INF) {
                    sb.append(0).append("\n");
                    continue;
                }
                findRoute(i, j);
                sb.append(deque.size()).append(" ");
                print();
            }
        }

        

        System.out.println(sb.toString());

    }

    private static void findRoute(int start, int end) {
        if (route[start][end] == 0) {
            deque.offerLast(start);
            deque.offerLast(end);
            return;
        }
        findRoute(start, route[start][end]);
        deque.removeLast();
        findRoute(route[start][end], end);
    }

    private static void print() {
        
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }
        sb.append("\n");
    }
}