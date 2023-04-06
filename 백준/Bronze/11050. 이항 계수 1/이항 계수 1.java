import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항 계수 1

public class Main {
    static int N, R;

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
        result /= fact(n - r);
        result /= fact(r);
        return result;
    }
    private static long fact(long n) {
        long result = 1l;
        for (int i = 1; i <= n; i++) {
            result = (result * i);
        }
        return result;
    }

    static long power(long x, long y) {
        long result = 1l;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x);
            }

            x = (x * x);
            y /= 2;
        }

        return result;
    }
}