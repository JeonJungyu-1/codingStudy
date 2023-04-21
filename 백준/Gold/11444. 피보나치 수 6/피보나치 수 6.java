import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 피보나치 수 6

public class Main {
    static long N;

    static Map<Long, Long> memo;
    static final long P = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new HashMap<>();
        N = Long.parseLong(br.readLine());
        long result = divide(N);

        System.out.println(result);


    }


    private static long divide(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        

        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            if (n % 2 == 0) {
                long a = divide(n/2);
                long b = divide(n/2 - 1);
                long result = (a * ((2 * b % P + a) % P)) % P;
                memo.put(n, result);
                return result;
            } else {
                long a = divide(n/2 + 1);
                long b = divide(n/2);
                long result = (a * a % P + b * b % P ) % P;
                memo.put(n, result);
                return result;
            }
        }
        

    }


}