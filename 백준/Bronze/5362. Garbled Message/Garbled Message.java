import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Garbled Message

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


        while (true) {
            String str = br.readLine();
            if (str == null) break;
            str = str.replace("iiing", "th");
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}