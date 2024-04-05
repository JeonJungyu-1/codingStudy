import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 소음

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


        BigInteger A = new BigInteger(br.readLine());
        String command = br.readLine();
        BigInteger B = new BigInteger(br.readLine());

        if (command.equals("*")) {
            System.out.println(A.multiply(B).toString(10));
        } else {
            System.out.println(A.add(B).toString(10));
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}