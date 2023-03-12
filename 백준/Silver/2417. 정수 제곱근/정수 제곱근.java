import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static Long N;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        long result = binarySearch(N);
        System.out.println(result);
    }

    private static long binarySearch(Long num) {
        long low = -1L;
        long high = 3037000500L;
        while (low + 1L < high) {
            long mid = (low + high) / 2;
            if (mid * mid < num) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Long.parseLong(br.readLine());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}