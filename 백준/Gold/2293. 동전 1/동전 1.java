import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 1

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static int[] memo;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(memo[K]);
    }

    private static void solve() throws IOException {
        init();
        memo[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = numbers[i]; j <= K; j++) {
                memo[j] += memo[j - numbers[i]];
            }
        }
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[N];    
        memo = new int[K + 1];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}