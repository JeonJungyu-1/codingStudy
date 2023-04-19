import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정수 삼각형

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(max);
    }

    private static void solve() throws IOException {
        init();
        max = dp[0][1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + dp[i][j];
                if (i == N - 1) max = Math.max(dp[i][j], max);
            }
        }

   
        print();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N + 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}