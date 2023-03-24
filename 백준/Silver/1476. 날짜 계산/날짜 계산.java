import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 날짜 계산

public class Main {
    
    static StringBuilder sb;
    static int E, S, M;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }


    private static void solve() {
        int[] numbers = new int[3];
        Arrays.fill(numbers, 1);
        int cnt = 1;
        while (true) {
            if (numbers[0] == E && numbers[1] == S && numbers[2] == M) break;

            numbers[0] = numbers[0] % 15 + 1;
            numbers[1] = numbers[1] % 28 + 1;
            numbers[2] = numbers[2] % 19 + 1;
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


    }
}