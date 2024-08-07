import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// HI-ARC=?

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

        int[] num = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(num[0] * num[1] - num[2] * num[3] * num[4]);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}