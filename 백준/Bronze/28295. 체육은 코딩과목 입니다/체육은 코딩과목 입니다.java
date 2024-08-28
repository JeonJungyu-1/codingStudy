import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체육은 코딩과목 입니다

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

        String[] direction = {"N", "E", "S", "W"};

        int current = 0;

        for (int i = 0; i < 10; i++) {
            int d = Integer.parseInt(br.readLine());
            current += 4;

            if (d == 1) {
                current++;
            } else if (d == 2) {
                current += 2;
            } else {
                current--;
            }

            current %= 4;
        }

        System.out.println(direction[current]);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}