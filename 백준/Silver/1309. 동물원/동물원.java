import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동물원

public class Main {
    
    static StringBuilder sb;
    static int N;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(memo[N]);
    }

    private static void solve() throws IOException {
        init();
        memo[1] = 3;
        memo[2] = 7;

        for (int i = 3; i <= N; i++) {
            memo[i] = (((memo[i - 1] * 2) % 9901) + memo[i - 2]) % 9901;
        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        memo = new long[N + 10];

    }
}