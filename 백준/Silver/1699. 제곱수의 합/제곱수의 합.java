import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 제곱수의 합
// dp

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }


        System.out.println(dp[N]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 3];





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}