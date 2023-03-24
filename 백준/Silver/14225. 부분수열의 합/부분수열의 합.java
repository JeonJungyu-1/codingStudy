import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 부분수열의 합

public class Main {
    static int N;
    static int[] numbers;
    static int[] numberCheck;
    static int minNum;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(minNum);
    }
    private static void solve() {
        subset(0, 0);
        for (int i = 1; i < numberCheck.length; i++) {
            if (numberCheck[i] == 0) {
                minNum = i;
                break;
            }
        }
    }
    private static void subset(int cnt, int sum) {
        if (cnt == N) {
            numberCheck[sum] = 1;
            return;
        }

        
        subset(cnt + 1, sum + numbers[cnt]);
        subset(cnt + 1, sum);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        numberCheck = new int[2000001];
    }
}