import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        int[] memo = new int[N];
        int maxCnt = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) memo[i] = Math.max(memo[i], memo[j] + 1);
            }
            maxCnt = Math.max(maxCnt, memo[i]);
        }

        System.out.println(maxCnt + 1);


    }
}