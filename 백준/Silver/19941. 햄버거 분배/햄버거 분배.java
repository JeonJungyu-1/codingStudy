import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 분배

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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] ch = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'H') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j >= ch.length) continue;
                    if (ch[j] == 'P') {
                        ch[j] = '0';
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}