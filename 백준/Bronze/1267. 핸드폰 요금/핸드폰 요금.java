import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 핸드폰 요금

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


        int N = Integer.parseInt(br.readLine());
        int y = 0;
        int m = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            y += (number / 30 + 1) * 10;
            m += (number / 60 + 1) * 15;
        }

        if (y == m) {
            sb.append("Y M ").append(y);
        } else if (y > m) {
            sb.append("M ").append(m);
        } else {
            sb.append("Y ").append(y);
        }

        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}