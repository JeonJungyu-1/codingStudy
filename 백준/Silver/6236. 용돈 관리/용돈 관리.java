import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 용돈 관리
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] money;
    static int highMoney;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        int result = binarySearch();
        System.out.println(result);
    }

    private static int binarySearch() {
        int low = highMoney - 1;
        int high = Integer.MAX_VALUE - highMoney;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }


    private static boolean check(int mid) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (sum + money[i] <= mid) {
                sum += money[i];
            } else {
                sum = money[i];
                cnt++;
            }
        }
        return cnt > M;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        highMoney = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            highMoney = Math.max(highMoney, money[i]);
        }
    }
}