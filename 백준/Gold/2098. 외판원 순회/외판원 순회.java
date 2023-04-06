import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 외판원 순회
// 비트 dp

public class Main {
    static int N;
    static int[][] dist, dp;
    static final int INF = Integer.MAX_VALUE / 100;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }

    private static void solve() throws NumberFormatException, IOException {
        init();

        int min = tps(1, 0);
        System.out.println(min);
        
    }

    private static int tps(int visited, int city) {
        if (visited == ((1 << N) - 1)) {
            return dist[city][0] == 0 ? INF : dist[city][0];
        }

        if (dp[visited][city] != -1) {
            return dp[visited][city];
        }


        dp[visited][city] = INF;
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) continue;

            if (dist[city][i] == 0) continue;

            int sum = tps(visited | (1 << i), i) + dist[city][i];
            dp[visited][city] = Math.min(sum, dp[visited][city]);
        }

        return dp[visited][city];

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        dp = new int[1 << N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

    }
}