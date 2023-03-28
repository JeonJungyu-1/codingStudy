import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 카드 구매하기
// dp

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] card;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    


    private static void solve() {
        // N까지 카드 개수마다 최대값을 저장해나가기
        memo[1] = card[1];
        for (int i = 2; i <= N; i++) {
            int len = i % 2 == 0 ? i / 2 : i / 2 + 1;
            for (int j = 1; j <= len; j++) {
                memo[i] = Math.max(memo[i], memo[j] + memo[i - j]);
            }
        }

        
        System.out.println(memo[N]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        card = new int[N + 1];
        memo = new int[N + 3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            memo[i] = card[i];
        }
    }
}