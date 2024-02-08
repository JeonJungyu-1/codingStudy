import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파티가 끝나고 난 뒤

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
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int lp = L * P;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - lp).append(" ");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}