import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1, 2, 3 더하기
// dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]

public class Main {
    static StringBuilder sb;
    static int T, N; 
    static int[] memo;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void dp(int N) {
        for (int i = 4; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        memo = new int[11];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            if (memo[N] != 0) {
                sb.append(memo[N]);
            } else {
                dp(N);
                sb.append(memo[N]);
            }
            sb.append("\n");
        }

    }
}