import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항 계수와 쿼리
// 페르마의 소정리

public class Main {
    
    static StringBuilder sb;
    static int T, N, K;
    static int P = 1000000007;
    static int[][] numbers;
    static long[] memo;

    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        init();
        memoFact();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(nCr(numbers[i][0], numbers[i][1])).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void memoFact() {
        memo[0] = 1;
        for (int i = 1; i < memo.length; i++) {
            memo[i] = (memo[i - 1] * i) % P;
        }
    }

    private static long nCr(int n, int r) {
        long result = ((memo[n] * power(memo[r], P - 2)) % P) * power(memo[n - r], P - 2) % P;
        return result;
    }

    static long power(long x, int y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) != 0) {
                result = (result * x) % P;
            }

            x = (x * x) % P;
            y >>= 1;
        }
        return result;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        numbers = new int[T][2];
        int maxN = Integer.MIN_VALUE;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            numbers[t][0] = N;
            numbers[t][1] = K;
            maxN = Math.max(maxN, N);
        }
        memo = new long[maxN + 1];
    }
}