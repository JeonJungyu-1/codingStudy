import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 생장점

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
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            if (level == 0) break;
            int cur = 1;
            for (int i = 0; i < level; i++) {
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                cur *= s;
                cur -= d;
            }
            sb.append(cur).append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}