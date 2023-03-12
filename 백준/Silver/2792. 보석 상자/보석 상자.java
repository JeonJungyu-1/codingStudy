import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보석 상자
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] jewel;
    static int highJewel;
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
        int high = highJewel;
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
        int cnt = 0;
        for (int i = 0; i < jewel.length; i++) {
            cnt += (jewel[i] + mid - 1) / mid;
        }

        return cnt > N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewel = new int[M];
        highJewel = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            highJewel = Math.max(highJewel, jewel[i]);
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}