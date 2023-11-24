import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 크냐?

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


        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) break;
            sb.append(A > B ? "Yes" : "No").append("\n");
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}