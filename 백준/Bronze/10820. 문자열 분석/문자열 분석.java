import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 분석

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
            String str = br.readLine();
            if (str == null) break;
            int[] cnt = new int[4];
            char[] ch = str.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                if (ch[i] >= 65 && ch[i] <= 90) {
                    cnt[1]++;
                } else if (ch[i] >= 97 && ch[i] <= 122) {
                    cnt[0]++;
                } else if (ch[i] >= 48 && ch[i] <= 57) {
                    cnt[2]++;
                } else {
                    cnt[3]++;
                }
            }

            for (int i = 0; i < 4; i++) {
                sb.append(cnt[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}