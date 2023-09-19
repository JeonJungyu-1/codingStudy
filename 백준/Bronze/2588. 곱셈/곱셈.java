import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 곱셈

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        String[] numbers = new String[2];
        for (int i = 0; i < 2; i++) {
            numbers[i] = br.readLine();
        }

        char[] ch = numbers[1].toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            sb.append(Integer.parseInt(numbers[0]) * (ch[i] - '0')).append("\n");
        }

        sb.append(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));

        System.out.println(sb.toString());
 
    }
}