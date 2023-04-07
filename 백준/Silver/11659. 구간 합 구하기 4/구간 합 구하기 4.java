import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 4
// 펜윅트리

public class Main {
    static int N, M, K;
    static int[] numbers;
    static int[] tree;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        tree = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            update(i, numbers[i]);
        }



        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(sum(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void update(int index, int diff) {
        while (index <= N) {
            tree[index] += diff;
            index += (index & -index);
        }
    }

    private static int sum(int index) {
        int result = 0;
        while (index > 0) {
            result += tree[(int)index];
            index -= (index & -index);
        }
        return result;
    }

    private static int sum(int i, int j) {
        return sum(j) - sum(i - 1);
    }
}