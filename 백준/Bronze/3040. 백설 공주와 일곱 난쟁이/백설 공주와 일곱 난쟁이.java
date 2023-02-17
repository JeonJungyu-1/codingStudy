import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] num;
    static int[] selectedNum;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        combi(0, 0, 0);
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = new int[9];
        selectedNum = new int[7];

        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        sb = new StringBuilder();
    }

    private static void combi(int cnt, int start, int sum) {
        if (cnt == 7 || sum > 100) {
            if (sum == 100) {
                for (int n : selectedNum) {
                    sb.append(n).append("\n");
                }
            }
            return;
        }


        for (int i = start; i < 9; i++) {
            selectedNum[cnt] = num[i];
            combi(cnt + 1, i + 1, sum + num[i]);
        }

    }
}