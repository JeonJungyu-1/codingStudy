import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long S;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
    }

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());
    }

    private static void solve() {
        long result = binarySearch();
        System.out.println(result);
    }

    private static long binarySearch() {
        long low = 1;
        long high = S;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (check(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static boolean check(long mid) {
        long sum = 0;
        sum = mid * (mid + 1) / 2;
        return sum <= S;
    }
}