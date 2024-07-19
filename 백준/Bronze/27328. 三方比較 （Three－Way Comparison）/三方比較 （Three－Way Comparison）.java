import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Three-Way Comparison

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


        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        if (A < B) {
            System.out.println(-1);
        } else if (A == B) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}