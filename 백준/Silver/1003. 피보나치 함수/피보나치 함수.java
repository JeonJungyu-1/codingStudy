import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수열
// dp
public class Main {
    static int T;
    static int N;
    static int[] memo;
    static int zero, one;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }

    private static void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        memo = new int[100];
        
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            
            memo[0] = 0;
            memo[1] = 1;

            int result = fibonacci(N);
            if (N != 0) {
                sb.append(memo[N - 1]).append(" ").append(memo[N]).append("\n");
            } else {
                sb.append(1).append(" ").append(0).append("\n");

            }
        }
        System.out.println(sb.toString());
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return memo[0];
        } else if (n== 1) {
            return memo[1];
        } 

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }
}