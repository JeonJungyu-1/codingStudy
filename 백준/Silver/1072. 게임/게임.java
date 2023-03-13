import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 게임
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static long N, M;
    static long win;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
    }

    private static void solve() {
        long result = binarySearch();
        System.out.println(win == calWin(result + N, result + M) ? -1 : result);
    }

    private static long binarySearch() {
        long low = 0;
        long high = Integer.MAX_VALUE;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (calWin(mid + N, mid + M) <= win) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private static long calWin(long n, long m) {
        return m * 100L / n;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        win = calWin(N, M);

    }
}