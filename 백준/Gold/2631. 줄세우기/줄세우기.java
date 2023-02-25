import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 줄세우기
// dp - lis 활용
// 전체 길이에서 lis의 길이를 빼주면 옮겨야하는 아이의 최소수가 나옴

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] dp;
    static int[] students;
    static int maxLis;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(N - maxLis);
    }

    private static void solve() {
        lis();
    }

    private static void lis() {
        // for (int i = 0; i < N; i++) {
        //     int cur = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (students[j] < students[i]) {
        //             if (cur < dp[j]) cur = dp[j];
        //         }
        //     }
        //     dp[i] = cur + 1;
        // }
        maxLis = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (students[j] < students[i]) {
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
        dp = new int[N];
        students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}