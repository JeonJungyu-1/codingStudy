import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 양팔 저울
// dp

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] weight;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        weight = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }

        dp = new int[sum + 1];

        // 초기 무게값 설정
        dp[0] = 1;
        for (int i = 1; i < weight.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= weight[i] && dp[j - weight[i]] == 1) {
                    dp[j] = 1;
                }
            }
        }

        
        // 가능한 무게 체크
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 1) continue;
            for (int j = 1; j <= i / 2; j++) {
                if (dp[j] != 1 && dp[i - j] != 1) continue;

                if (dp[j] == 0) dp[j] = 2;
                if (dp[i - j] == 0) dp[i - j] = 2;
            }
        }


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());

            sb.append(number <= sum && dp[number] >= 1 ? "Y" : "N").append(" ");
        }

        System.out.println(sb.toString());


    }

}