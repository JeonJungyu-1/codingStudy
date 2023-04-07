import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 2
// 펜윅트리

public class Main {
    static int N, M, K;
    static long[] atree, btree;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        atree = new long[N + 1];
        btree = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            rangeUpdate(i, i, Long.parseLong(br.readLine()));
        }



        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = 0;
            if (a == 1) {
                d = Long.parseLong(st.nextToken());
            }

            if (a == 1) {
                rangeUpdate(b, c, d);
            } else {
                sb.append(rangeSum(b, c)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static void rangeUpdate(long a, long b, long x) {
        update(1, a, x);
        update(1, b + 1, -x);
        update(2, a, x * (a - 1));
        update(2, b + 1, -x * b);
    }
    private static void update(int type, long index, long x) {
        long[] tree = type == 1 ? atree : btree;
        while (index <= N) {
            tree[(int)index] += x;
            index += (index & -index);
        }
    }

    static long getValue(int type, long index) {
        long[] tree = type == 1 ? atree : btree;
        long result = 0;
        while (index > 0) {
            result += tree[(int)index];
            index -= (index & -index);
        }
        return result;
    }

    static long prefixSum(long x) {
        return getValue(1, x) * x - getValue(2, x);
    }

    private static long rangeSum(long a, long b) {
        return prefixSum(b) - prefixSum(a - 1);
    }
}