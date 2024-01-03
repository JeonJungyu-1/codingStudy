import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열의 합

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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int result = -1;
        int cnt = 0;
        for (int i = L; i <= 100; i++) {
            if (i % 2 == 0) {
                if (((N / i) * 2 + 1) * (i / 2) == N) {

                    if (i / 2 >= ((N / i) + 2)) continue;

                    result = (N / i);
                    cnt = i;
                    break;
                }
            } else {
                if (N % i == 0) {
                    if ((N / i) * (i) == N) {

                        if (i / 2 >= ((N / i) + 1)) continue;

                        result = (N / i);
                        cnt = i;
                        break;
                    }
                }
            }
        }
     

        if (result == -1) {
            sb.append(-1);
        } else {
            for (int i = 0; i < cnt; i++) {
                sb.append(result - ((cnt - 1)/2) + i).append(" ");
            }
        }

        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}