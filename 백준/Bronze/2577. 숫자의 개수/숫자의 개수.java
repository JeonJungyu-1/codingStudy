import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자의 개수

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int mul = 1;
        for (int i = 0; i < 3; i++) {
            mul *= Integer.parseInt(br.readLine());
        }

        int[] numbers = new int[10];
        while (mul != 0) {
            numbers[mul % 10]++;
            mul /= 10;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(numbers[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}