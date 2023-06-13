import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최댓값

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            int number = Integer.parseInt(br.readLine());
            if (max < number) {
                max = number;
                index = i + 1;
            }
        }

        sb.append(max).append("\n").append(index);
        System.out.println(sb.toString());

    }
}