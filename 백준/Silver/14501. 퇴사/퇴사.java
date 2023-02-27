import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사
// dp

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] dp;
    static Consulting[] list;
    static class Consulting {
        int day;
        int money;
        public Consulting(int day, int money) {
            this.day = day;
            this.money = money;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(dp[N]);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            
            int newDay = i + list[i].day;
            if (newDay > N) continue;
            dp[newDay] = Math.max(dp[newDay], dp[i] + list[i].money);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        list = new Consulting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list[i] = new Consulting(d, m);
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}