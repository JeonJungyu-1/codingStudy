import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파이프 옮기기 2
// dfs or dp

public class Main {
    static int N;
    static int[][] map;
    static long[][][] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        
        
    }
    private static void solve() {
        memo[0][1][2] = 1L;

        // 0: 가로 , 1 : 세로, 2: 대각선        
        for (int i = 1; i < N + 1; i++) {
            for (int j = 3; j < N + 1; j++) {
                if (map[i][j] == 1) continue;
                memo[0][i][j] = memo[0][i][j - 1] + memo[2][i][j - 1];
                if (i == 1) continue;
                memo[1][i][j] = memo[1][i - 1][j] + memo[2][i - 1][j];

                if (map[i - 1][j] == 1 || map[i][j - 1] == 1) continue;
                memo[2][i][j] = memo[2][i - 1][j - 1] + memo[1][i - 1][j - 1] + memo[0][i - 1][j - 1];
            }
        }

        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += memo[i][N][N];
        }
        System.out.println(sum);
    }







    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        memo = new long[N + 1][N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}