import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
// dp

public class Main {
    static int N, K;
    static int[] w;
    static int[] v;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        
    }


    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                

                if (j < w[i]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j - w[i]] + v[i], memo[i - 1][j]);
                }
            }
        }

        System.out.println(memo[N][K]);

    }

    
    private static void init() throws FileNotFoundException, IOException {
        // System.setIn(new FileInputStream("src/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[N + 1];
        v = new int[N + 1];
        memo = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
    }
}