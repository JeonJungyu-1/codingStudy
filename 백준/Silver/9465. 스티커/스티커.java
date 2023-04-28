import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스티커

public class Main {
    
    static StringBuilder sb;
    static int T, N;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            memo = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    memo[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            memo[0][1] += memo[1][0];
            memo[1][1] += memo[0][0];
            for (int i = 2; i < N; i++) {
                memo[0][i] += Math.max(memo[1][i - 2], memo[1][i - 1]);
                memo[1][i] += Math.max(memo[0][i - 2], memo[0][i - 1]);
            }


            sb.append(Math.max(memo[0][N - 1], memo[1][N - 1])).append("\n");
        }

        System.out.println(sb.toString());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}