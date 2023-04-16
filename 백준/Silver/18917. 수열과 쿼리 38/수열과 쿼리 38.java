import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 수열과 쿼리 38

public class Main {
    
    static StringBuilder sb;
    static int N;
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
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        long sum = 0;
        long xor = 0;
        int number;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    number = Integer.parseInt(st.nextToken());
                    sum += number;
                    xor ^= number;
                    break;
                case 2:
                    number = Integer.parseInt(st.nextToken());
                    sum -= number;
                    xor ^= number;
                    break;
                case 3:
                    sb.append(sum).append("\n");
                    break;
                case 4:
                    sb.append(xor).append("\n");
                    break;
            
            }
        }

        System.out.println(sb.toString());







        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}