import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직감 삼각형의 두 변

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

        int cnt = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            if (a == 0 && b == 0 & c == 0) break;
            sb.append("Triangle #").append(cnt).append("\n");
            if (c != -1 && (a >= c || b >= c)) {
                sb.append("Impossible.");
            } else {
                double result = 0;
                if (a == -1) {
                    sb.append("a = ");
                    result = Math.sqrt(c * c - b * b);
                } else if (b == -1) {
                    sb.append("b = ");
                    result = Math.sqrt(c * c - a * a);
                    
                } else {
                    sb.append("c = ");
                    result = Math.sqrt(a * a + b * b);
                    
                }
                sb.append(String.format("%.3f",result));
            }
            sb.append("\n\n");            
            cnt++;
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}