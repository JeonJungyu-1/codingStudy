import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합

public class Main {
    
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int number, max = -1001, sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number = Integer.parseInt(st.nextToken());
            sum = Math.max(sum + number, number);
            max = Math.max(sum, max);
        }

        System.out.println(max);

    }
}