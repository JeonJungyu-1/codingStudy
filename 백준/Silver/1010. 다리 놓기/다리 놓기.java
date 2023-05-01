import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다리 놓기

public class Main {
    
    static StringBuilder sb;
    static int T, N, M;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        memo = new int[31][31];
        memo[0][0] = 1;
        for (int i = 1; i <= 30; i++) {
            memo[i][0] = memo[i][i] = 1;
        }

        


        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
            }
        }


        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            sb.append(memo[N][M]).append("\n");
        }

        System.out.println(sb.toString());
    }
}