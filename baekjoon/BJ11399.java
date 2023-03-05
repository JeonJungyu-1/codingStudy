package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// ATM
// 1. 오름차순으로 정렬
// 2. 차례대로 기다리는 시간 구해서 더하기
public class BJ11399 {
    static StringBuilder sb;
    static int N;
    static int[] time;
    static int minTime;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minTime);
    }

    private static void solve() {
        Arrays.sort(time);
        for (int i = 0; i < N; i++) {
            minTime +=  (N - i) * time[i];
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
