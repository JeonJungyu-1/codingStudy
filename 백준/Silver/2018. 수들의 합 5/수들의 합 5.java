import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 5

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

        int left = 1;
        int right = 1;
        int sum = 1;
        int cnt = 0;
        while (left <= right && right <= N) {
            // System.out.println(sum);
            // System.out.println(left + "," + right + "=" + sum);
            if (sum == N) {
                cnt++;
            }
            
            if (sum < N) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
               
            }

        }

        System.out.println(cnt);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}