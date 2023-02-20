import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] set, one;
    static int minSet, minOne;
    static int minPrice;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(minPrice);
    }
    private static void solve() {
        minPrice = (N / 6) * minSet;
        if (((N % 6) * minOne) > minSet) {
            minPrice += minSet;
        } else {
            minPrice += (N % 6) * minOne;
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new int[M];
        one = new int[M];

        minSet = minOne = Integer.MAX_VALUE;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            set[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());

            minOne = Math.min(one[i], minOne);
            minSet = Math.min(Math.min(one[i] * 6, set[i]), minSet);

        }
    }
}