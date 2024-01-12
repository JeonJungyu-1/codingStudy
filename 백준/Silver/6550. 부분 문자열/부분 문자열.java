import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분 문자열

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
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input);

            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();
            int sIndex = 0;
            for (int i = 0; i < t.length; i++) {
                if (s[sIndex] == t[i]) sIndex++;

                if (sIndex == s.length) break;
            }

            sb.append(sIndex == s.length ? "Yes" : "No").append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}