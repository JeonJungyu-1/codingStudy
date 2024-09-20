import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체육은 수학과목 입니다

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


        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        
        int result = Math.min(H, W);
        System.out.println(result * 100 / 2);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}