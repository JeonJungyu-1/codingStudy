package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
// LIS

public class BJ11053 {
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static int[] dp;
    static int maxLis;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(maxLis);
    }

    private static void solve() {

        maxLis = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLis = Math.max(maxLis, dp[i]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
