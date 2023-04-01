import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1, 2, 3 더하기 5
// dp

public class Main {
    
    static StringBuilder sb;
    static int T, N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new long[4][1000001];
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 3;

        dp[1][1] = 1;

        dp[2][2] = 1;

        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            for (int i = 4; i <= N; i++) {
                if (dp[0][i] == 0) {
                    dp[1][i] = (dp[2][i - 1] + dp[3][i - 1]) % 1000000009;
                    dp[2][i] = (dp[1][i - 2] + dp[3][i - 2]) % 1000000009;
                    dp[3][i] = (dp[1][i - 3] + dp[2][i - 3]) % 1000000009;
                    dp[0][i] = (dp[1][i] + dp[2][i] + dp[3][i]) % 1000000009;
                }
            }

            sb.append(dp[0][N]).append("\n");
        }

        System.out.println(sb.toString());



    }
}