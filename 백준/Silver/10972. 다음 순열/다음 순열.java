import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] firstNumbers;
    static boolean result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        if (result) {
            for (int i = 0; i < N; i++) {
                sb.append(firstNumbers[i]).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }
    private static void solve() {
        result = np(N - 1);
    }

    private static boolean np(int size) {
        int i = size;
        while (i > 0 && firstNumbers[i - 1] > firstNumbers[i]) i--;
        if (i == 0) return false;

        int j = size;
        while (firstNumbers[i - 1] > firstNumbers[j]) j--;
        int temp = firstNumbers[i - 1];
        firstNumbers[i - 1] = firstNumbers[j];
        firstNumbers[j] = temp;

        int k = size;
        while (i < k) {
            temp = firstNumbers[i];
            firstNumbers[i] = firstNumbers[k];
            firstNumbers[k] = temp;
            i++;
            k--;
        }

        return true;
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        firstNumbers = new int[N];
        for (int i = 0; i < N; i++) {
            firstNumbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}