import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 사람 네트워크2
// 플로이드 워셜

public class Solution {
    static int T, N;
    static int[][] dp;
    static final int INF = 1001;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    if (i == j) continue;
                    if (number == 0) number = INF;
                    dp[i][j] = number;
                }
            }
            

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (k == i) continue;
                    for (int j = 0; j < N; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }


            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int result = 0;
                for (int j = 0; j < N; j++) {
                    if (dp[i][j] == INF) continue;
                    result += dp[i][j];
                }
                min = Math.min(result, min);
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");

        }

        System.out.println(sb.toString());
        
    }
}