import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기
// 이분 탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] tree;
    static long highTree;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }


    private static void solve() {
        binarySearch();
    }

    private static void binarySearch() {

        long low = 0;
        long high = highTree;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (isAvailable(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }

    private static boolean isAvailable(long mid) {
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] > mid) sum += tree[i] - mid;
        }
        return sum >= M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        highTree = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            highTree = Math.max(highTree, tree[i]);
        }
    }
}