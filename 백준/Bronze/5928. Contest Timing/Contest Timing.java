import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Contest Timing

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
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (D < 11 || (D == 11 && H < 11) || (D == 11 && H == 11 && M < 11)) {
            System.out.println(-1);
            return;
        }

        int result = (D - 11) * 24 * 60 + (H - 11) * 60 + (M - 11);
        System.out.println(result);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}