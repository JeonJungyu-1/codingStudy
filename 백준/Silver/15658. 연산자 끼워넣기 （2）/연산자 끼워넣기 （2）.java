import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기 (2)

public class Main {
    
    static StringBuilder sb;

    static int N;
    static int[] numbers;
    static int[] operator;
    static int min, max;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());

    }

    private static void solve() throws IOException {
        init();
        dfs(1, numbers[0]);
        print();
    }

    private static void dfs(int cnt, int result) {
        if (cnt == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        if (operator[0] != 0) {
            operator[0]--;
            dfs(cnt + 1, result + numbers[cnt]);
            operator[0]++;
        }

        if (operator[1] != 0) {
            operator[1]--;
            dfs(cnt + 1, result - numbers[cnt]);
            operator[1]++;
        }

        if (operator[2] != 0) {
            operator[2]--;
            dfs(cnt + 1, result * numbers[cnt]);
            operator[2]++;
        }

        if (operator[3] != 0) {
            operator[3]--;
            dfs(cnt + 1, result / numbers[cnt]);
            operator[3]++;

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

   
    }
}