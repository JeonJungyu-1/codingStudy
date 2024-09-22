import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Quadrants

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
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            
            if (x == 0 || y == 0) {
                sb.append("AXIS");
            } else if (y > 0) {
                if (x > 0) {
                    sb.append("Q1");
                } else {
                    sb.append("Q2");
                }
            } else {
                if (x > 0) {
                    sb.append("Q4");
                } else {
                    sb.append("Q3");
                }
            }
            
            if (x == 0 && y == 0) break;
            sb.append("\n");
        }

        System.out.println(sb.toString());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}