import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나누기

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
        int F = Integer.parseInt(br.readLine());

        N /= 100;
        N *= 100;

        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                if (i < 10) sb.append("0");
                sb.append(i);
                System.out.println(sb.toString());
                break;
            }
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}