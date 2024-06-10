import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Rats

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
        int A = Integer.parseInt(st.nextToken()) + 1;
        int B = Integer.parseInt(st.nextToken()) + 1;
        int C = Integer.parseInt(st.nextToken()) + 1;

        int result = A * B / C;
        result--;
        System.out.println(result);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}