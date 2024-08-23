import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Intercepting Information

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

        boolean isSuccess = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 0 && num != 1) {
                isSuccess = false;
                break;
            }
        }

        System.out.println(isSuccess ? "S" : "F");



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}