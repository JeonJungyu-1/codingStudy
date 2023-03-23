import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (6)
// 조합

public class Main {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;
    static int[] selectedNumbers;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(sb.toString());
    }
    private static void solve() {
        Arrays.sort(numbers);
        combination(0, 0);
    }
    private static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int num : selectedNumbers) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            selectedNumbers[cnt] = numbers[i];
            combination(cnt + 1, i + 1);
        }

    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selectedNumbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
    }
}