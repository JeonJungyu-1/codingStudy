import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이상한 곱셈

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
        st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                sum += ((a[i] - '0') * (b[j] - '0'));
            }
        }

        System.out.println(sum);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}