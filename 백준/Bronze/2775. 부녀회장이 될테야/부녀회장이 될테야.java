import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부녀회장이 될테야

public class Main {
    
    static StringBuilder sb;
    static int[][] memo;
    static int K, N, T;
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
        StringTokenizer st;
        sb = new StringBuilder();

        memo = new int[16][16];
        for (int i = 0; i < memo.length; i++) {
            memo[0][i] = memo[i][1] = 1;
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 2; j < memo[0].length; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1]; 
            }
        }

  

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            sb.append(memo[K + 1][N]).append("\n");
        }

        System.out.println(sb.toString());

    }
}