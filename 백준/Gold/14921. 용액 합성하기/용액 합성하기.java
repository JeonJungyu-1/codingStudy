import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액 합성하기
// 투포인터

public class Main {
    static int N;
    static int[] water;
    static int min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(min);
    }
    private static void solve() {
        twoPointer();
    }

    private static void twoPointer() {
        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = water[start] + water[end];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                if (sum == 0) return;
            }


            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        min= Integer.MAX_VALUE;
    }
}