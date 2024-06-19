import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 몇개고?

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
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if ((T >= 12 && T <= 16) && S == 0) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}