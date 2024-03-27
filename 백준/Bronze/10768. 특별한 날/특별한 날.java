import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 특별한 날

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

        int m = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        if (m == 2) {
            if (d == 18) {
                sb.append("Special");
            } else if (d < 18) {
                sb.append("Before");
            } else {
                sb.append("After");
            }
        } else if (m < 2) {
            sb.append("Before");
        } else {
            sb.append("After");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}