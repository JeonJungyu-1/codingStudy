import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] symbol;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }
    private static void solve() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        calResult(1, numbers[0]);
    }
    private static void calResult(int cnt, int result) {
        if (cnt == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        //+ - * / 
        if (symbol[0] != 0) {
            symbol[0]--;
            calResult(cnt + 1, result + numbers[cnt]);
            symbol[0]++;
        }

        if (symbol[1] != 0) {
            symbol[1]--;
            calResult(cnt + 1, result - numbers[cnt]);
            symbol[1]++;
        }
        
        if (symbol[2] != 0) {
            symbol[2]--;
            calResult(cnt + 1, result * numbers[cnt]);
            symbol[2]++;
        }
        
        if (symbol[3] != 0) {
            symbol[3]--;
            calResult(cnt + 1, result / numbers[cnt]);
            symbol[3]++;
        }

        

    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        numbers = new int[N];
        symbol = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            symbol[i] = Integer.parseInt(st.nextToken());
        }
    }
}