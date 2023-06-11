import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
   

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int diff = B.length() - A.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= diff; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) cnt++;
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);

    }
}