import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 적어도 대부분의 배수

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

        int[] numbers = new int[5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        
        int number = 1;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (number % numbers[i] == 0) {
                    cnt++;
                }
            }

            if (cnt >= 3) {
                System.out.println(number);
                break;
            }

            number++;


        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}