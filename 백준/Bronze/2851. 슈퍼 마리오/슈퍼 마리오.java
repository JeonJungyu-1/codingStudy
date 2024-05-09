import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 슈퍼 마리오

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

        int[] number = new int[10];
        for (int i = 0; i < 10; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int pre = 100 - sum;
            int next = sum + number[i] - 100;
            if (pre < next) {
                break;
            }
            sum += number[i];
        }

        System.out.println(sum);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}