import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균 점수

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


        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            if (score < 40) score = 40;
            sum += score;
        }
        System.out.println(sum/5);

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}