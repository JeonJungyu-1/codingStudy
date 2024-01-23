import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// FYI

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


        char[] ch = br.readLine().toCharArray();

        if (ch[0] == '5' && ch[1] == '5' && ch[2] == '5') {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}