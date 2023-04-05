import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (9)

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] selectedNumbers;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];
        selectedNumbers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        perm(0);

        System.out.println(sb.toString());
        
    }
    private static void perm(int cnt) {
        if (cnt == M) {
            for (int number : selectedNumbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i] || lastNumber == numbers[i]) continue;
            visited[i] = true;
            lastNumber = numbers[i];
            selectedNumbers[cnt] = numbers[i];
            perm(cnt + 1);
            visited[i] = false;
        }

    }
}