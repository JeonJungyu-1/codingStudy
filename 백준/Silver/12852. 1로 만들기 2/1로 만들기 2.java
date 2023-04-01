import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        sb.append(dp[N][0]).append("\n").append(N).append(" ");
        int index = dp[N][1];
        while (index != -1) {
            sb.append(index).append(" ");
            index = dp[index][1];
        }

        System.out.println(sb.toString());
    }

    private static void solve() {
        dp[1][0] = 0;
        dp[1][1] = -1;

        dp[2][0] = 1;
        dp[2][1] = 1;

        dp[3][0] = 1;
        dp[3][1] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = i - 1;
            if (i % 2 == 0 && dp[i / 2][0] + 1 < dp[i][0]) {
                dp[i][0] = dp[i / 2][0] + 1;
                dp[i][1] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3][0] + 1 < dp[i][0]) {
                dp[i][0] = dp[i / 3][0] + 1;
                dp[i][1] = i / 3;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 3][2];


        // bw.write(sb.toString());
        // bw.flush();hjhn  
        // bw.close();    
    }
}