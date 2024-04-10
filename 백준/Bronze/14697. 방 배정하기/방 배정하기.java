import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방 배정하기

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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sum = 0;
        outer:
        for (int i = 0; i <= N/A; i++) {
            for (int j = 0; j <= N/B; j++) {
                for (int k = 0; k <= N/C; k++) {
                    sum = A * i + B * j + C * k;
                    if (sum == N) break outer;
                }
            }
        }

        System.out.println(sum == N ? 1 : 0);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}