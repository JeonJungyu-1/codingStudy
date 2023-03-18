import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입국심사
// 이분탐색

public class Main {
    static StringBuilder sb;
    static int N;
    static long M;
    static long[] time;
    static long highTime;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        long result = binarySearch();
        System.out.println(result);
    }

    private static long binarySearch() {
        long low = 0;
        long high = highTime * M;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (check(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static boolean check(long mid) {
        long cnt = 0;
        for (int i = 0; i < time.length; i++) {
            if (cnt >= M) break;
            cnt += mid / time[i];
        }

        return cnt < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        time = new long[N];
        highTime = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            time[i] = Long.parseLong(br.readLine());
            highTime = Math.max(highTime, time[i]);
        }


    }
}