import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// RGB 거리
// dp

public class Main {
    static int N;
    static long[][] color;
    static long[][] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        
    }
    private static void solve() {
        explore();

        long min = Math.min(Math.min(memo[N][0], memo[N][1]), memo[N][2]);
        System.out.println(min);
    }
    private static void explore() {
        memo[1][0] = color[1][0];
        memo[1][1] = color[1][1];
        memo[1][2] = color[1][2];
        for (int i = 1; i <= N; i++) {
            memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + color[i][0];
            memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + color[i][1];
            memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + color[i][2];
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new long[N + 1][N + 1];
        memo = new long[N + 3][N + 3];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Long.parseLong(st.nextToken());
            }
        }
    }
}