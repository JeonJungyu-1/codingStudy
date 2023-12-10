import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사장님 도박은 재미로 하셔야 합니다

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

        int result = 0;
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == -1) break;
            result += number;
        }

        System.out.println(result);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}