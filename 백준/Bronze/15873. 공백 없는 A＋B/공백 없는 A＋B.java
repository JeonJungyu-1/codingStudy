import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 공백 없는 A+B

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

        String number = br.readLine();

        int len = number.length() - 1;
        if (number.charAt(len) == '0') len--;

        int A = Integer.parseInt(number.substring(0, len));
        int B = Integer.parseInt(number.substring(len));

        System.out.println(A + B);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}