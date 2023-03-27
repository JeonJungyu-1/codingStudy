import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (7)
// 중복 순열

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[] numbers;
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
        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int number : selectedNumbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 0; i < N; i++) {
            selectedNumbers[cnt] = numbers[i];
            perm(cnt + 1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selectedNumbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}