package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 계단오르기
// dp

public class BJ2537 {
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(dp[N]);
    }

    private static void solve() {
        dp[0] = numbers[0];
        dp[1] = numbers[1];
        dp[2] = Math.max(dp[0], dp[1]) + numbers[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + numbers[i - 1], dp[i - 2]) + numbers[i];
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 3];
        dp = new int[N + 3];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
