import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[][] dp;
    static int min;
    static int minPeople;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(minPeople);
    }

    private static void solve() throws IOException {
        init();
        


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }



        
        for (int i = 1; i <= N; i++) {
            int sum = getSum(i);
            if (min > sum || (min == sum && minPeople > i)) {
                min = sum;
                minPeople = i;
            }
        }

        print();
    }

    private static int getSum(int i) {
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            sum += dp[i][j];
        }
        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 5001);
            dp[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dp[s][e] = dp[e][s] = 1;
        }

        min = Integer.MAX_VALUE;
        minPeople = Integer.MAX_VALUE;





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}