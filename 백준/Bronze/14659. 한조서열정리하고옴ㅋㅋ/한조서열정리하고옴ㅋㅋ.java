import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt;
    static int maxCnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxCnt = Integer.MIN_VALUE;
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (start > height) {
                cnt++;
            } else {
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 0;
                start = height;
            }
        }
        
        if (cnt != 0) maxCnt = Math.max(cnt, maxCnt);
        System.out.println(maxCnt);
    }
}