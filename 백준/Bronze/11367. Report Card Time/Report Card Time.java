import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Report Card Time

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


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            sb.append(name).append(" ");
            if (score >= 97) {
                sb.append("A+");
            } else if (score >= 90) {
                sb.append("A");
            } else if (score >= 87) {
                sb.append("B+");
            } else if (score >= 80) {
                sb.append("B");
            } else if (score >= 77) {
                sb.append("C+");
            } else if (score >= 70) {
                sb.append("C");
            } else if (score >= 67) {
                sb.append("D+");
            } else if (score >= 60) {
                sb.append("D");
            } else {
                sb.append("F");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}