import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 카드 구매하기 2
// dp

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(dp[N - 1]);
    }

    private static void solve() {
        for (int i = 1; i < N; i++) {
            int len = i/2;
            for (int j = 0; j <= len; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j - 1]);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}