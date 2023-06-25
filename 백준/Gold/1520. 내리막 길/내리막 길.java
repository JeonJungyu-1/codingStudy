import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 내리막 길
// 깊이 우선 탐색

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(dp[0][0]);
    }

    private static void solve() throws IOException {
        init();
        dfs(0, 0);
        print();
    }

    private static int dfs(int r, int c) {

        if (r == N - 1 && c == M - 1) {
            return 1;
        }

        if (dp[r][c] != -1) return dp[r][c];
        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc)) continue;
            if (map[r][c] > map[nr][nc]) {
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }   


        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

    }
}