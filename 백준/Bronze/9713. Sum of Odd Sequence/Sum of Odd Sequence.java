import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Sum of Odd Sequence

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

        int[] sum = new int[100];
        sum[0] = 1;
        int add = 3;
        for (int i = 1; i < 100; i++) {
            sum[i] = (sum[i - 1] + add);
            add += 2;
        }
        

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            sb.append(sum[num/2]).append("\n");
        }

        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}