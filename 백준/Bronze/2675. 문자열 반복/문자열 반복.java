import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 반복

public class Main {
    
    static StringBuilder sb;
    static int T, N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
   

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            char[] ch = st.nextToken().toCharArray();
            for (char c : ch) {
                for (int i = 0; i < N; i++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
            
        }

        System.out.println(sb.toString());

    }
}