import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합
// 투포인터

public class Main {
    static StringBuilder sb;
    static int N, S;
    static int[] numbers;
    static int min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        int start = 0;
        int end = 0;
        int sum = 0;
        min = Integer.MAX_VALUE;
        while (end <= N) {

            if (sum < S) {
                sum += numbers[end];
                end++;
            } else {
                sum -= numbers[start];
                min = Math.min(min, end - start);
                start++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}