import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기

public class Main {
    static int M, N;
    static boolean[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        numbers = new boolean[N + 1];
        int sqrtN = (int)Math.sqrt(N);
        numbers[1] = true;
        for (int i = 2; i <= sqrtN + 1; i++) {
            if (numbers[i]) continue;
            for (int j = i * 2; j <= N; j += i) {
                numbers[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!numbers[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());

        
    }
}