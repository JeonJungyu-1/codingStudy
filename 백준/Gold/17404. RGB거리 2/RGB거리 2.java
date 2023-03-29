import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// RGB 거리 2
// dp

public class Main {
    static int N;
    static int[][] color;
    static int[][][] memo;
    static int min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();

        
    }
    private static void solve() {
        memo[1][0][0] = color[1][0];
        memo[1][0][1] = 1001;
        memo[1][0][2] = 1001;

        memo[1][1][0] = 1001;
        memo[1][1][1] = color[1][1];
        memo[1][1][2] = 1001;

        memo[1][2][0] = 1001;
        memo[1][2][1] = 1001;
        memo[1][2][2] = color[1][2];

        for (int i = 2; i < N + 1; i++) {
            memo[i][0][0] = Math.min(memo[i - 1][1][0], memo[i - 1][2][0]) + color[i][0];
            memo[i][0][1] = Math.min(memo[i - 1][1][1], memo[i - 1][2][1]) + color[i][0];
            memo[i][0][2] = Math.min(memo[i - 1][1][2], memo[i - 1][2][2]) + color[i][0];

            memo[i][1][0] = Math.min(memo[i - 1][0][0], memo[i - 1][2][0]) + color[i][1];
            memo[i][1][1] = Math.min(memo[i - 1][0][1], memo[i - 1][2][1]) + color[i][1];
            memo[i][1][2] = Math.min(memo[i - 1][0][2], memo[i - 1][2][2]) + color[i][1];

            memo[i][2][0] = Math.min(memo[i - 1][0][0], memo[i - 1][1][0]) + color[i][2];
            memo[i][2][1] = Math.min(memo[i - 1][0][1], memo[i - 1][1][1]) + color[i][2];
            memo[i][2][2] = Math.min(memo[i - 1][0][2], memo[i - 1][1][2]) + color[i][2];
        }


        min = Math.min(memo[N][1][0], memo[N][2][0]);

        min = Math.min(min, memo[N][0][1]);
        min = Math.min(min, memo[N][2][1]);
        
        min = Math.min(min, memo[N][0][2]);
        min = Math.min(min, memo[N][1][2]);
        

        System.out.println(min);



    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N + 1][3];
        memo = new int[N + 3][3][3];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}