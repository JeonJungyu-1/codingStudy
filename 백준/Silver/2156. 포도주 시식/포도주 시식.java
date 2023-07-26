import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 포도주 시식
// dp

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 10];
        int[] numbers = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 3; i < numbers.length; i++) {
            dp[i] = Math.max(dp[i - 3] + numbers[i - 1] +numbers[i], dp[i - 2] + numbers[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        
        System.out.println(dp[numbers.length - 1]);

    }
}