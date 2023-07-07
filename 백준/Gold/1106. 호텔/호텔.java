import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 호텔
// 배낭, dp

public class Main {
    
    static StringBuilder sb;
    static int[] v, w, memo;
    static int C, N;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        init();
        Arrays.fill(memo, Integer.MAX_VALUE/100);
        memo[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 1100; j++) {
                if (j >= w[i]) {
                    memo[j] = Math.min(memo[j - w[i]] + v[i], memo[j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = C; i <= 1100; i++) {
            min = Math.min(min, memo[i]);
        }
        System.out.println(min);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        v = new int[N];
        w = new int[N];
        memo = new int[1101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }




    }
}