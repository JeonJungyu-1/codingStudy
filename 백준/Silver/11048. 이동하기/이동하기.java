import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이동하기

public class Main {
    
    static StringBuilder sb;
    static int[] dr = {1, 0, 1};
    static int[] dc = {0, 1, 1};
    static int[][] map;
    static int N, M;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = map[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = map[i][0] + dp[i - 1][0];
        }


        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}