import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] numbers;
    static int cnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        int high = numbers[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (high <= numbers[i]) {
                cnt += numbers[i] - high + 1;
                numbers[i] = high - 1;
            }
            high = numbers[i];
        }
    }

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}