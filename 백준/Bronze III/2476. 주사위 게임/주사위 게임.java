import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 게임

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

        int max = Integer.MIN_VALUE;
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum = 0;
            if (a == b && b == c) {
                sum = 10000 + (a * 1000);
            } else if (a == b) {
                sum = 1000 + (a * 100);
            } else if (b == c) {
                sum = 1000 + (b * 100);
            } else if (a == c) {
                sum = 1000 + (c * 100);
            } else {
                sum = Math.max(a, Math.max(b, c)) * 100;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}