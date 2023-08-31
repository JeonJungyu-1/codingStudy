import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어 뒤집기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder s = new StringBuilder(st.nextToken());
                sb.append(s.reverse().toString()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}