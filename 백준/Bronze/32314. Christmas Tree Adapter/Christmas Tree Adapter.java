import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Christmas Tree Adapter

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

        int a = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        if (a <= (w / v)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}