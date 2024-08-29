import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 운동장 한 바퀴

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


        double c = Double.parseDouble(br.readLine());
        double a = Double.parseDouble(br.readLine());
        
        System.out.println((c * 2) + (a * 3.141592 * 2));



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}