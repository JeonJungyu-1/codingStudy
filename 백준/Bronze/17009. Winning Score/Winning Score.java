import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Winning Score

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


        int A = Integer.parseInt(br.readLine()) * 3 + Integer.parseInt(br.readLine()) * 2 + Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine()) * 3 + Integer.parseInt(br.readLine()) * 2 + Integer.parseInt(br.readLine());

        System.out.println(A > B ? "A" : A == B ? "T" : "B");


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}