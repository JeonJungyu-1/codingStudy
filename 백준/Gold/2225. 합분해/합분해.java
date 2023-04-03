import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 합분해
// dp

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        Arrays.fill(dp[0], 1);
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];

    }
}