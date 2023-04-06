import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항계수 2

public class Main {
    static int N, R;
    static int P = 10007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }
    private static void solve() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        long result = nCr(N, R);
        sb.append(result);

        System.out.println(sb.toString());
        
    }
    private static long nCr(long n, long r) {
        long result = 1l;
        result *= fact(n);
        result = (result * power(fact(n - r), P - 2)) % P;
        result = (result * power(fact(r), P - 2)) % P;
        return result;
    }
    private static long fact(long n) {
        long result = 1l;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % P;
        }
        return result;
    }

    static long power(long x, long y) {
        long result = 1l;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % P;
            }

            x = (x * x) % P;
            y /= 2;
        }

        return result;
    }
}