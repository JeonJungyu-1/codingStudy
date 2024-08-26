import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 홀짝홀짝

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
        char[] ch = br.readLine().toCharArray();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < N; i++) {
            int num = ch[i] - '0';
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println(even > odd ? 0 : even < odd ? 1 : -1);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}