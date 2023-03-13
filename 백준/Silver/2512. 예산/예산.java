import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 예산
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] number;
    static int highNumber;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        int result = binarySearch();
        System.out.println(result);
    }

    private static int binarySearch() {
        int low  = 1;
        int high = highNumber + 1;
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
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= mid) {
                sum += mid;
            } else {
                sum += number[i];
            }
        }
        return sum <= M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N];
        highNumber = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            highNumber = Math.max(highNumber, number[i]);
        }
        M = Integer.parseInt(br.readLine());
    }
}