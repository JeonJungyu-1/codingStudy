import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] number;
    public static void main(String[] args) throws IOException {
        solve();
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            number = new int[N];
            int zero = 0;
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
                if (number[i] == 0) zero++;
            }

            StringBuffer aNumber = new StringBuffer("");
            StringBuffer bNumber = new StringBuffer("");
            Arrays.sort(number);

            if (zero > 0) {
                changeNum(0, zero);
                changeNum(1, zero + 1);
            }

            for (int i = 0; i < number.length; i++) {
                if (i % 2 == 0) {
                    aNumber.append(number[i]);
                } else {
                    bNumber.append(number[i]);
                }
            }

            int sum = Integer.parseInt(aNumber.toString()) + Integer.parseInt(bNumber.toString());
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());

    }
    private static void changeNum(int a, int b) {
        int temp = number[a];
        number[a] = number[b];
        number[b] = temp;
    }
}