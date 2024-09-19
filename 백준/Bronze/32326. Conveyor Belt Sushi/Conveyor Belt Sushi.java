import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Conveyor Belt Sushi

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


        int result = 0;
        result += (Integer.parseInt(br.readLine()) * 3);
        result += (Integer.parseInt(br.readLine()) * 4);
        result += (Integer.parseInt(br.readLine()) * 5);

        System.out.println(result);

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}