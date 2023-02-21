import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;
    static long result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    private static void solve() {
        long result = divide(B);
        System.out.print(result);
    }
    private static long divide(long n) {
        if (n == 1L) {
            return A % C;
        }

        if (n % 2L == 0L) {
            long val = divide(n/2L) % C;
            return val * val % C;
        } else {
            return (A * divide(n - 1L) % C) % C;
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
    }
}