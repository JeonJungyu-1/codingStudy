import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 욕심쟁이 판다
// dfs

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int result) {
        System.out.println(result);
    }

    private static void solve() throws IOException {
        init();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
                result = Math.max(result, dp[i][j]);
            }
        }


        print(result);
    }

    private static int dfs(int r, int c) {

        
        if (dp[r][c] != 0) return dp[r][c];
        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc)) continue;
            if (map[nr][nc] > map[r][c]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }

        }

        return dp[r][c];

        

    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}