import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0
// 큰 동전부터 차례대로 최대개수만큼 빼주기
// 성립하려면 각 동전이 배수여야 하는데, 입력에서 배수라고 정해줌
public class Main {
    static int N, K;
    static int[] coin;
    static StringBuilder sb;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        
        for (int i = coin.length - 1; i >= 0; i--) {
            if (coin[i] > K || K == 0) continue;

            cnt += K / coin[i];
            K %= coin[i];
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}