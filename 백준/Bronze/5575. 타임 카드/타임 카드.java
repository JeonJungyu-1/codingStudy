import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 타임 카드

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

        for (int i = 0; i < 3; i++) {
            int[] result = new int[3];
            st = new StringTokenizer(br.readLine());
            int[] a = new int[3];
            for (int j = 0; j < 3; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[3];
            for (int j = 0; j < 3; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < 3; j++) {
                if (b[j] < a[j]) {
                    if (result[j - 1] == 0) {
                        result[j - 2]--;
                        result[j - 1] += 60;
                    }
                    result[j - 1]--;
                    b[j] += 60;
                }
                result[j] = b[j] - a[j];
            }
            
            for (int j = 0; j < 3; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}