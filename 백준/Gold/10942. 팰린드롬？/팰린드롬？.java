import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 팰린드롬?
// dp

public class Main {
    static int N;
    static int[] numbers;
    static int[][] dp;
    static int M;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        
        
        dp = new int[N + 2][N + 2];


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (numbers[i] != numbers[j]) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + 1;
                }
            }
        }

        
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int cnt = (e - s) / 2 + 1;
            sb.append(dp[e][s] == cnt ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
        

    }
}