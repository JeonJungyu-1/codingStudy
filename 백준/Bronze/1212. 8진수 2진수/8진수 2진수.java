import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8진수 2진수

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

        if (ch[0] == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            int n = ch[i] - '0';
            sb.append(n/4);
            n%=4;
            sb.append(n/2);
            n%=2;
            sb.append(n);
        }

        int subIndex = ch[0] == '1' ? 2 : (ch[0] == '3' || ch[0] == '2') ? 1: 0;
        
        System.out.println(sb.toString().substring(subIndex));



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}