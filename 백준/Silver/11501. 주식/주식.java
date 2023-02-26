import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 주식
// 그리디

public class Main {
    static StringBuilder sb;
    static int T, N;
    static long[] stock;
    static long max;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }


    private static void solve() {

        long high = stock[0];
        for (int i = 0; i < N - 1; i++) {
            if (stock[i] >= stock[i + 1]) {
                max += high - stock[i + 1];
            } else {
                if (high > stock[i + 1]) {
                    max += high - stock[i + 1];
                } else {
                    high = stock[i + 1];
                }
            }
            // System.out.println(max);
        }
        

    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            stock = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stock[N - 1 - i] = Long.parseLong(st.nextToken());
            }
            max = 0;
            solve();
            
            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}