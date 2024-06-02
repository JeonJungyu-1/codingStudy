import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Счастье Мистера Бина

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
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                result++;
            } else {
                result--;
            }
        }
        System.out.println(result > 0 ? "Happy" : "Sad");



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}