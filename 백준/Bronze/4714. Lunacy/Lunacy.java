import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Lunacy

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
            double number = Double.parseDouble(br.readLine());
            if (number < 0) break;
            sb.append("Objects weighing ").append(String.format("%.2f", number)).append(" on Earth will weigh ").append(String.format("%.2f", number * 0.167)).append(" on the moon.").append("\n");
        }



        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}