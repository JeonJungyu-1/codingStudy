import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 큰 수 (BIG)

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

        // BigInteger number = new BigInteger(br.readLine());
        // System.out.println(number.mod(BigInteger.valueOf(20000303)).toString());

        char[] ch = br.readLine().toCharArray();
        int result = 0;
        for (int i = 0; i < ch.length; i++) {
            result = (result * 10 + ch[i] - '0') % 20000303;
        }

        System.out.println(result);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}