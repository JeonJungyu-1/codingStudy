import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점수계산

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


        int score = 0;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num = 1;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == 0) {
                num = 1;
                continue;
            }
            score += num;
            num++;
            
        }

        System.out.println(score);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}