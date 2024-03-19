import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 사탕 선생 고창영

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

        int T = Integer.parseInt(br.readLine());
        br.readLine();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < N; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            sb.append(sum.remainder(BigInteger.valueOf(N)).equals(new BigInteger("0")) ? "YES" : "NO").append("\n");
            br.readLine();
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}