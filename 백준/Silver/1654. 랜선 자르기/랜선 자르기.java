import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜선 자르기
// 이분탐색

public class Main {
    static StringBuilder sb;
    static int N; 
    static long K;
    static long[] lanList;
    static long longLength;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    
    

    private static void solve() {
        long result = binarySearch();
        System.out.println(result);
    }

    private static long binarySearch() {
        long low = 1;
        long high = longLength + 1;
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
        for (int i = 0; i < lanList.length; i++) {
            if (lanList[i] >= mid) sum += lanList[i]/mid;
        }
        return sum >= K;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        lanList = new long[N];
        longLength = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            lanList[i] = Long.parseLong(br.readLine());
            longLength = Math.max(longLength, lanList[i]);
        }
    }
}