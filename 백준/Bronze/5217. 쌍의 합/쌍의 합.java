import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쌍의 합

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            sb.append("Pairs for ").append(number).append(": ");

            for (int j = 1; j <= number/2; j++) {
                if (j == number - j) break;
                sb.append(j).append(" ").append(number - j).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (number != 2 && number != 1) sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}