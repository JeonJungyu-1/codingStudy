import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A + B - C

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


        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int intA = Integer.parseInt(A);
        int intB = Integer.parseInt(B);
        int intC = Integer.parseInt(C);

        System.out.println(intA + intB - intC);
        System.out.println(Integer.parseInt(A + B) - intC);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}