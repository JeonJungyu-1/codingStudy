import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항계수 3

public class Main {
    static long N, R;
    static long P;
    static long[] memo;

    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }
    private static void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        P = 1000000007;
        memo = new long[(int)N + 1];
        memoFact(P);
        long result = nCr(N, R, P);
        sb.append(result);

        System.out.println(sb.toString());
        
    }

    private static void memoFact(long p) {
        memo[0] = 1;
        for (int i = 1; i < memo.length; i++) {
            memo[i] = (memo[i - 1] * i) % p;
        }
    }

    private static long nCr(long n, long r, long p) {
        long result = 1l;

        if (n < p) {
            return ((memo[(int)n] * modInverse(memo[(int)r], p)) % p) * modInverse(memo[(int)(n - r)], p) % p;
        } else {
            while (n > 0 || r > 0) {
                long a = n % p;
                long b = r % p;
                if (a < b) return 0;
                result = (result * memo[(int)a]) % p;
                result = (result * modInverse((memo[(int)b] * memo[(int)a - (int)b]) % p, p)) % p;
                n /= p;
                r /= p;
            }
        }

        return result;
    }

    static long modInverse(long n, long p) { 
        return power(n, p-2, p); 
    } 

    static long power(long x, long y, long p) {
        long result = 1l;
        while (y > 0) {
            if ((y & 1) != 0) {
                result = (result * x) % p;
            }

            x = (x * x) % P;
            y >>= 1;
        }

        return result;
    }
}