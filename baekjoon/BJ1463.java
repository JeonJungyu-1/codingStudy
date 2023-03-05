package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1로 만들기

public class BJ1463 {
    static StringBuilder sb;
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(memo[N]);
    }

    private static void solve() {
        memo[1] = 0;
        memo[2] = 1;

        for (int i = 3; i <= N; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 2 == 0) {
                memo[i] = Math.min(memo[i / 2] + 1, memo[i]);
            }
            
            if (i % 3 == 0) {
                memo[i] = Math.min(memo[i / 3] + 1, memo[i]);
            }

        }

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 3];
    }
}
