import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세제곱의 합

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
        int sum = 0;
        int sum2 = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        for (int i = 1; i <= N; i++) {
            sum2 += (i * i * i);
        }

        sb.append(sum).append("\n").append(sum * sum).append("\n").append(sum2);

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}