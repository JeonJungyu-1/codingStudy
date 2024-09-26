import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Pizza

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


            st = new StringTokenizer(br.readLine());
            double a1 = Double.parseDouble(st.nextToken());
            double p1 = Double.parseDouble(st.nextToken());
            st = new StringTokenizer(br.readLine());
            double r1 = Double.parseDouble(st.nextToken());
            double p2 = Double.parseDouble(st.nextToken());

            double a2 = r1 * r1 * Math.PI;

            if (a1/p1 < a2/p2) {
                sb.append("Whole pizza");
            } else {
                sb.append("Slice of pizza");
            }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}