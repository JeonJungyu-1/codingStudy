import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 앱
// dp - 배낭문제

public class Main {
    static int N, M;
    static int[] w;
    static int[] v;
    static int[] dp; 
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int size = 0;
        for (int i = 0; i < N; i++) {
            size += v[i];
        }
        dp = new int[size + 1];

        for (int i = 0; i < N; i++) {
            for (int j = size; j >= 0; j--) {
                if (j >= v[i]) {
                    dp[j] = Math.max(dp[j - v[i]] + w[i], dp[j]);
                }
            }
        }


        int result = 0;
        for (int i = 0; i <= size; i++) {
            if (dp[i] >= M) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        w = new int[N];
        v = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
    }
}