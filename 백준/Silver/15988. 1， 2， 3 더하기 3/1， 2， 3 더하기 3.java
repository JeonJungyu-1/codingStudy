import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1, 2, 3 더하기 3
// dp

public class Main {
    
    static StringBuilder sb;
    static int T, N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        solve();
    }
    



    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int index = 4;
        dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            while (index <= N) {
                dp[index] = (((dp[index - 1] + dp[index - 2]) % 1000000009) + dp[index - 3]) % 1000000009;
                index++;
            }
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb.toString());


    }
}