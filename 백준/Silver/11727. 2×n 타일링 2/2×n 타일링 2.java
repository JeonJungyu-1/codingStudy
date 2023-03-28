import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2 X n 타일링 2

public class Main {
    static int n;
    static int[] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n + 3];
        memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                memo[i] = ((memo[i - 1] * 2) + 1) % 10007;
            } else {
                memo[i] = ((memo[i - 1] * 2) - 1) % 10007;
            }
        }

        System.out.println(memo[n]);
    }
}