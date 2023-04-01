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
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new int[4][1000001];
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 3;

        dp[1][1] = 1;

        dp[2][2] = 1;

        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        int index = 4;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            while (index <= N) {
                dp[1][index] = (dp[2][index - 1] + dp[3][index - 1]) % 1000000009;
                dp[2][index] = (dp[1][index - 2] + dp[3][index - 2]) % 1000000009;
                dp[3][index] = (dp[1][index - 3] + dp[2][index - 3]) % 1000000009;
                index++;
            }
            
            dp[0][N] = (((dp[1][N] + dp[2][N]) % 1000000009) + dp[3][N]) % 1000000009;
            sb.append(dp[0][N]).append("\n");
        }

        System.out.println(sb.toString());



    }
}