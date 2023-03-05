package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 01타일 - dp
// 점화식 - f(1) = 1 / f(n) = f(n - 1) + f(n - 2)
// top-down 사용 -- 재귀 많아서 불가능
// bottom-up 사용
public class BJ1904 {
    static StringBuilder sb;
    static int N;
    static int[] memo;
    static int result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(result);
    }

    private static void solve() {
        memo[1] = 1;
        memo[2] = 2;
        result = dp(N);
    }

    // top-down
    // private static int dp(int n) {
    //     if (n == 1) {
    //         return 1;
    //     } else if (n == 2) {
    //         return 2;
    //     }

    //     if (memo[n] != 0) {
    //         return memo[n];
    //     } else {
    //         memo[n] = dp(n - 2) + dp(n - 1);
    //         if (memo[n] > 15746) memo[n] %= 15746;
    //         return memo[n];
    //     }
    // }

    // bottom-up
    private static int dp(int n) {
        if (memo[n] == 0) {
            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i - 2] + memo[i - 1];
                if (memo[i] >= 15746) memo[i] %= 15746;
            }
        }
        return memo[n];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 2];





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
