import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유진수

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
        int N = ch.length;
        boolean isSuccess = false;
        for (int i = 1; i < N; i++) {
            int a = 1;
            int b = 1;

            for (int j = 0; j < i; j++) {
                a *= (ch[j] - '0');
            }


            for (int j = i; j < N; j++) {
                b *= (ch[j] - '0');
            }

            if (a == b) isSuccess = true;

        }

        System.out.println(isSuccess ? "YES" : "NO");


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}