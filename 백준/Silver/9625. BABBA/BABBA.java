import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BABBA

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
        int[] memo = new int[N + 10];
        
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        

        sb.append(memo[N - 1]).append(" ").append(memo[N]);
        System.out.println(sb.toString());
    }
}