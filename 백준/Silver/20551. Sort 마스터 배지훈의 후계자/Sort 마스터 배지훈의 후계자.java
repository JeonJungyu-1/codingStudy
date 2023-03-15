import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // Sort 마스터 배지훈의 후계자
    // lower_bound

    static int N, M;
    static int[] question;
    public static void main(String[] args) throws IOException {
        solve();
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        question = new int[N];
        for (int i = 0; i < N; i++) {
            question[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(question);

        for (int i = 0; i < M; i++) {
            int answer = Integer.parseInt(br.readLine());
            int result = binarySearch(answer);
            sb.append(result == N || question[result] != answer ? -1 : result).append("\n");
        }

        System.out.println(sb.toString());
    }
    private static int binarySearch(int answer) {
        int low = -1;
        int high = N;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (question[mid] < answer) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
}