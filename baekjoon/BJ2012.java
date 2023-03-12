package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 등수 매기기

public class BJ2012 {
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static boolean[] isSelected;
    static long cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            cnt += Math.abs(i - numbers[i]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        isSelected = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
