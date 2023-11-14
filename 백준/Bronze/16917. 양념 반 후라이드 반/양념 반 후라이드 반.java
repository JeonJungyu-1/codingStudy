import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 양념 반 후라이드 반

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
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int result = 0;
        if (A + B < C * 2) {
            result = A * X + B * Y;
        } else {
            if (X > Y) {
                result += (Y * C * 2);
                if (A > C * 2) {
                    result += (X - Y) * C * 2;
                } else {
                    result += (X - Y) * A;
                }
            } else {
                result += (X * C * 2);

                if (B > C * 2) {
                    result += (Y - X) * C * 2;
                } else {
                    result += (Y - X) * B;
                }
            }
        }

        System.out.println(result);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}