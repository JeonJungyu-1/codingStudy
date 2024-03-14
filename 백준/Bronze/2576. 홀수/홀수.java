import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 홀수

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

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 1) {
                if (min > num) {
                    min = num;
                }
                sum += num;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        sb.append(sum).append("\n").append(min);

        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}