import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] selectedNumbers;
    static boolean[] isVisited;
    static int max;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(max);
    }

    private static void solve() {
        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == N) {
            calNumbers();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            selectedNumbers[cnt] = numbers[i];
            perm(cnt + 1);
            selectedNumbers[cnt] = 0;
            isVisited[i] = false;
        }
    }

    private static void calNumbers() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(selectedNumbers[i] - selectedNumbers[i + 1]);
        }

        max = Math.max(max, sum);
    }

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selectedNumbers = new int[N];
        isVisited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;

    }
}