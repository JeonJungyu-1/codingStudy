import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 과자 나눠주기
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int M, N;
    static int[] snack;
    static int highSnack;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        int result = binarySearch();
        System.out.println(result);
    }

    private static int binarySearch() {
        int low = 0;
        int high = highSnack + 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static boolean check(int mid) {
        int sum = 0;
        for (int i = 0; i < snack.length; i++) {
            if (snack[i] >= mid) sum += snack[i] / mid;
        }
        return sum >= M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snack = new int[N];
        highSnack = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            highSnack = Math.max(highSnack, snack[i]);
        }

    }
}