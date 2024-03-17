import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2진수 8진수

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

        char[] ch = br.readLine().toCharArray();

        int n = 1;
        int number = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            number += n * (ch[i] - '0');

            if (n == 4) {
                n = 1;
                sb.append(number);
                number = 0;
                continue;
            }

            n *= 2;
        }

        if (number != 0 || sb.length() == 0) {
            sb.append(number);
        }

        System.out.println(sb.reverse().toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}