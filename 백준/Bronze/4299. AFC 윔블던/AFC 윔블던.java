import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// AFC 윔블던

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

        st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        int a = (sum + diff);
        int b = a / 2;
        int c = sum - b;

        if (a % 2 == 1 || c < 0) {
            System.out.println(-1);
        } else {
            sb.append(Math.max(b, c)).append(" ").append(Math.min(b, c));
            System.out.println(sb.toString());
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}