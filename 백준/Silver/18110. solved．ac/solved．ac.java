import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// solved.ac

public class Main {
    
    static StringBuilder sb;
    static int[] number;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int result) {
        System.out.println(result);

    }

    private static void solve() throws IOException {
        init();
        Arrays.sort(number);
        int upDownNumber = (int)Math.round((N * 15D)/100D);
        int result = 0;
        for (int i = upDownNumber; i < N - upDownNumber; i++) {
            result += number[i];
        }
        result = (int)Math.round(result/(N - upDownNumber * 2D));
        print(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
    }
}