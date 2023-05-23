import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분수찾기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        int i = 1;
        int sum = 1;
        while (true) {
            if (X < sum) {
                i--;
                sum -= i;
                break;
            }
            sum += i;
            i++;
        }

        if (i % 2 == 0) {
            sb.append(X - sum + 1).append("/").append(i - X + sum);
        } else {
            sb.append(i - X + sum).append("/").append(X - sum + 1);
        }

        System.out.println(sb.toString());

    }
}