import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 무한 문자열

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

        String s = br.readLine();
        String t = br.readLine();

        String repeatS = s.repeat(t.length());
        String repeatT = t.repeat(s.length());
        if (repeatS.equals(repeatT)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}