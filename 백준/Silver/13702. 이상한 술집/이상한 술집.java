import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이상한 술집

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static int[] water;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();

        long result = binarySearch();
        System.out.println(result);
        print();
    }

    private static long binarySearch() {
        long low = 0;
        long high = water[N - 1] + 1;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (check(mid) >= K) {
                low = mid;
            } else {
                high = mid;
            }
        } 


        return low;
    }

    private static long check(long mid) {

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += (water[i] / mid);
        }

        return result;

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        water = new int[N];
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(water);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}