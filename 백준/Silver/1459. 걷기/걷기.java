import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 걷기
// 많은 조건 분기
public class Main {
    static StringBuilder sb;
    static long W, S;
    static long[]  home;
    static long minTime;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minTime);
    }

    private static void solve() {
        long min = Math.min(home[0], home[1]);
        long max = Math.max(home[0], home[1]);
        if (W * 2 <= S) {
            minTime = (min + max) * W;
        } else {
            minTime = min * S;
            if (W > S) {
                if ((max - min) % 2 == 0) {
                    minTime += (max - min) * S;
                } else {
                    minTime += (max - min - 1) * S + W;
                }
            } else {
                minTime += W * (max - min);
            }
        }


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        home = new long[2];

        home[0] = Long.parseLong(st.nextToken());
        home[1] = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}