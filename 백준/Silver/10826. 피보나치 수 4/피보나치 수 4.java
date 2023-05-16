import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb;
    static int N;
    static BigInteger[] memo;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(N == 0 ? 0 :memo[2].toString(10));
    }

    private static void solve() throws IOException {
        init();

        for (int i = 2; i <= N; i++) {
            memo[2] = memo[1].add(memo[0]);
            memo[0] = memo[1];
            memo[1] = memo[2];
        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        memo = new BigInteger[3];
        memo[0] = new BigInteger("0");
        memo[1] = new BigInteger("1");
        memo[2] = new BigInteger("1");

    }
}