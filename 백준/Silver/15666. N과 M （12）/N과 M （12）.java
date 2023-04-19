import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M(12)

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[] numbers;
    static int[] selectedNumbers;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        Arrays.sort(numbers);
        combination(0, 0);
        print();
    }

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int number : selectedNumbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = start; i < N; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) continue;
            selectedNumbers[cnt] = numbers[i];
            combination(cnt + 1, i);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selectedNumbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}