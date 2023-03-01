import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시험감독

public class Main {
    static StringBuilder sb;
    static int N;
    static Long B, C;
    static int[] numbers;
    static long cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            if (numbers[i] <= B) {
                cnt++;
            } else {
                if ((numbers[i] - B) % C == 0) {
                    cnt += (numbers[i] - B) / C + 1;
                } else {
                    cnt += (numbers[i] - B) / C + 2;
                }
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}