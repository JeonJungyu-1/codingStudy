import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
// 투포인터

public class Main {
    static int N;
    static long[] water;
    static long[] min;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(min[1]).append(" ").append(min[2]).append(" ").append(min[3]);
        System.out.println(sb.toString());
    }

    private static void solve() {
        Arrays.sort(water);
        for (int i = 1; i < water.length - 1; i++) {
            twoPointer(i);
        }
    }

    private static void twoPointer(int mid) {
        int start = 0;
        int end = water.length - 1;

        while (start < mid && mid < end) {

            long sum = calSum(start, mid, end);

            if (Math.abs(sum) < min[0]) {
                min[0] = Math.abs(sum);
                min[1] = water[start];
                min[2] = water[mid];
                min[3] = water[end];
                if (sum == 0) return;
            }


            if (sum < 0) {
                if (start + 1 == mid) {
                    return;
                }
                start++;
            } else {
                if (mid + 1 == end) {
                    return;
                } 
                end--;
            }
        }

    }

    private static long calSum(int start, int mid, int end) {
        return water[start] + water[mid] + water[end];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            water[i] = Long.parseLong(st.nextToken());
        }
        min = new long[4];
        min[0] = Long.MAX_VALUE;
    }
}