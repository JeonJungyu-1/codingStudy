package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 조합

public class BJ2407 {
    static StringBuilder sb;
    static long N, M;
    static BigInteger result;
    static BigInteger divideNumber;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(result);
    }

    private static void solve() {
        result = new BigInteger("1");
        divideNumber = new BigInteger("1");
        for (long i = 0L; i < M; i++) {
            result = result.multiply(BigInteger.valueOf(N - i));
            divideNumber = divideNumber.multiply(BigInteger.valueOf(i + 1));
        }

        result = result.divide(divideNumber);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
    }
}
