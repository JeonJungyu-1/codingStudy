import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Welcome to SMUPC!

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


        char[] ch = new String("WelcomeToSMUPCWelcomeToSMUPC").toCharArray();

        int N = Integer.parseInt(br.readLine());
        System.out.println(ch[N % 14 + 13]);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}