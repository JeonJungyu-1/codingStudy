import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 윷놀이

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

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    result--;
                } else {
                    result++;
                }
            }


            if (result == 2) {
                sb.append("A");
            } else if (result == 0) {
                sb.append("B");
                
            } else if (result == -2) {
                sb.append("C");
                
            } else if (result == -4) {
                sb.append("D");
                
            } else {
                sb.append("E");

            }
            sb.append("\n");

            
        }
        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}