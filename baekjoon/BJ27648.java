package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 증가 배열 만들기

public class BJ27648 {
    static StringBuilder sb;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        if (N + M - 1 > K) {
            sb.append("NO");
        } else {
            sb.append("YES").append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(i + j + 1).append(" ");
                }
                sb.append("\n");
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
