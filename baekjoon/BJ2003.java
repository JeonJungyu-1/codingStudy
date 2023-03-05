package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 2
// 투포인터

public class BJ2003 {
    static StringBuilder sb;
    static int N; 
    static int M;
    static int[] numbers;
    static int count;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() {
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end <= N ) {
            if (sum < M) {
                sum += numbers[end];
                end++;
            } else {
                sum -= numbers[start];
                start++;
            }
            if (sum == M) {
                count++;
            } 
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

    }
}
