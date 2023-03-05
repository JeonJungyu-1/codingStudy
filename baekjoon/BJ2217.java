package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 로프
// 그리디

public class BJ2217 {
    static StringBuilder sb;
    static int N;
    static int[] ropeList;
    static int maxWeight;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(maxWeight);
    }

    private static void solve() {
        Arrays.sort(ropeList);
        maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < ropeList.length; i++) {
            maxWeight = Math.max(maxWeight, ropeList[i] * (ropeList.length - i));
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        ropeList = new int[N];
        for (int i = 0; i < N; i++) {
            ropeList[i] = Integer.parseInt(br.readLine());
        }

    }
}
