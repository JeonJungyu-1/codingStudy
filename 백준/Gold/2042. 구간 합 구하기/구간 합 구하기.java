import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기
// 펜윅트리

public class Main {
    static int N, M, K;
    static long[] numbers;
    static long[] tree;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new long[N + 1];
        tree = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            update(i, numbers[i]);
        }



        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update((int)b, c - numbers[(int)b]);
                numbers[(int)b] = c;
            } else {
                sb.append(sum(b, c)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static void update(int index, long diff) {
        while (index <= N) {
            tree[index] += diff;
            index += (index & -index);
        }
    }

    private static long sum(long index) {
        long result = 0l;
        while (index > 0) {
            result += tree[(int)index];
            index -= (index & -index);
        }
        return result;
    }

    private static long sum(long i, long j) {
        return sum(j) - sum(i - 1);
    }
}