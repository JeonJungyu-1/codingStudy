import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이친수
// dp
// 점화식 : dp[N] = dp[N - 1] + dp[N - 2]

public class Main {
    static StringBuilder sb;
    static int N;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(memo[N]);
    }

    private static void solve() {
        memo[1] = 1L;
        memo[2] = 1L;
        for (int i = 3; i <= N; i++) {
            memo[i] = memo[i - 2] + memo[i - 1]; 
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        memo = new long[N + 3];



    }
}