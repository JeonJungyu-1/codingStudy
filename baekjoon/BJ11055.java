package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 큰 증가하는 부분 수열
// dp - lis

public class BJ11055 {
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static int[] memo;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(maxSum);
    }

    private static void solve() {
        // maxSum = Integer.MIN_VALUE;
        // for (int i = 0; i < N; i++) {
        //     memo[i] = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (numbers[i] > numbers[j]) {
        //             memo[i] = Math.max(memo[i], memo[j] + numbers[j]);
        //         }
        //     }
        //     maxSum = Math.max(maxSum, memo[i] + numbers[i]);
        // }



        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + numbers[i]);
                }
            }
            maxSum = Math.max(maxSum, memo[i]);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        memo = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            memo[i] = numbers[i];
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
