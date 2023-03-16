import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static long[] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
        
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
    
        memo = new long[103];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            if (memo[N] == 0) {
                dp();
            }

            sb.append(memo[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void dp() {
        for (int i = 4; i <= N; i++) {
            if (memo[i] == 0) {
                memo[i] = memo[i - 2] + memo[i - 3];
            }
        }
    }
}