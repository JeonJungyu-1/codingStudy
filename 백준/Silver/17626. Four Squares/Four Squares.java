import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Four Squares

public class Main {
    static int N;
    static int min;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        int end = (int)Math.floor(Math.sqrt(N));
        dp = new int[N + 1];
        Arrays.fill(dp, 5);
        dp[0] = 0;

        for (int i = 0; i < N + 1; i++) {
            if (dp[i] == 4) continue;
            for (int j = 1; j < end + 1; j++) {
                int sum = i + j * j;
                if (sum > N) break;
                dp[sum] = Math.min(dp[i] + 1, dp[sum]);
            }
        }


        System.out.println(dp[N]);
        
        
    }
  
}