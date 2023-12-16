import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 줄자접기

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

        double N = Double.parseDouble(br.readLine());

        double[][] number = new double[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            number[i][0] = Double.parseDouble(st.nextToken());
            number[i][1] = Double.parseDouble(st.nextToken());

            Arrays.sort(number[i]);
        }

        double diff = 0;

        for (int i = 0; i < 3; i++) {
            double a = number[i][0];
            double b = number[i][1];
            double c = (a + b) / 2;
            diff = 0;
            
            if (c < N/2) {
                diff = N - c * 2;
            }

            N = Math.max(c, N - c);
            
            for (int j = i + 1; j < 3; j++) {
                if (c * 2 == (number[j][0] + number[j][1])) {
                    i++;
                    continue;
                }

                if (number[j][0] > c) {
                    number[j][0] = (c * 2 - number[j][0]);
                }

                if (number[j][1] > c) {
                    number[j][1] = (c * 2 - number[j][1]);
                }

                number[j][0] += diff;
                number[j][1] += diff;

                Arrays.sort(number[j]);
            }

        }

        System.out.println(N);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}