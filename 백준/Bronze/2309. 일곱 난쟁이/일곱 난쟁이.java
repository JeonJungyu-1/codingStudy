import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] heights;
    static int[] answer;
    static boolean isSuccess = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        heights = new int[9];
        answer = new int[7];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        combi(0, 0, 0);
        Arrays.sort(answer);
        for (int anw: answer) {
            sb.append(anw).append("\n");
        }

        System.out.println(sb);

    }

    static void combi(int cnt, int start, int sum) {
        if (isSuccess) return;
        if (cnt == 7) {
            if (sum == 100) {
                isSuccess = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            answer[cnt] = heights[i];
            combi(cnt + 1, i + 1, sum + answer[cnt]);
            if (isSuccess) return;
            answer[cnt] = 0;
        }

    }
}
