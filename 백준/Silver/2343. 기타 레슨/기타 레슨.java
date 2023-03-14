import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기타 레슨
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] video;
    static int sumVideo;
    static int highVideo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        int result = binarySearch();
        System.out.println(result);
    }

    private static int binarySearch() {
        int low = highVideo - 1;
        int high = sumVideo;
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
            sum += video[i];
            if (sum > mid) {
                sum = video[i];
                cnt++;
            }
        }
        return cnt > M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        video = new int[N];
        st = new StringTokenizer(br.readLine());
        highVideo = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            sumVideo += video[i];
            highVideo = Math.max(highVideo, video[i]);
        }
    }
}