import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 선물

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double result = binarySearch(N, L, W, H);

        System.out.println(result);

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static double binarySearch(int n, int l, int w, int h) {
        double low = 0;
        double high = Math.min(h, Math.min(l, w)) + 1;

        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            if (isCheck(mid, n, l, w, h)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static boolean isCheck(double mid, int n, int l, int w, int h) {
        double sum = Math.floor(l/mid) * Math.floor(w/mid) * Math.floor(h/mid);
        return sum >= n;
    }

}