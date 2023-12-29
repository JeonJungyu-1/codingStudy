import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기타리스트

public class Main {
    
    static StringBuilder sb;
    static int N, S, M;
    static int[][] memo;
    static int[] volume;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int i = M; i >= 0; i--) {
            if (memo[N][i] == N - 1) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(-1);
    }

    private static void solve() throws IOException {
        init();
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -2);
        }
        memo[0][S] = -1;
        for (int i = 0; i < N; i++) {


            for (int j = 0; j <= M; j++) {
                int prev = j - volume[i];
                int next = j + volume[i];
                if (prev >= 0 && memo[i][j] == i - 1) {
                    memo[i + 1][prev] = i;
                }

                if (next <= M && memo[i][j] == i - 1) {
                    memo[i + 1][next] = i;
                }
            }

        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volume = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N + 1][M + 1];


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}