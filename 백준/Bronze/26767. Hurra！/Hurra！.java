import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Hurra!

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

        for (int i = 1; i <= N; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                sb.append("Wiwat!");
            } else if (i % 7 == 0) {
                sb.append("Hurra!");
            } else if (i % 11 == 0) {
                sb.append("Super!");
            } else {
                sb.append(i);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}