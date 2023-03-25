import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//리모컨
//브루트포스

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int nLength;
    static int M;
    static boolean[] breakButton;
    static int min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        if (N == 100) { 
            min = 0;
        } else {
            explore(0, 0);
            min = Math.min(min, Math.abs(N - 100));
        }
    }

    private static void explore(int cnt, int sum) {
        if (cnt == nLength - 1 && cnt != 0) {
            min = Math.min(min, Math.abs(sum - N) + nLength - 1);
        }

        if (cnt == nLength) {
            min = Math.min(min, Math.abs(sum - N) + nLength);
        }

        if (cnt == nLength + 1) {
            min = Math.min(min, Math.abs(sum - N) + nLength + 1);
            return;
        }
        if (cnt == 1 && sum == 0) return;

        for (int i = 0; i < 10; i++) {
            if (breakButton[i]) continue;
            explore(cnt + 1, sum * 10 + i);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        String s = br.readLine();
        nLength = s.length();
        N = Integer.parseInt(s);


        M = Integer.parseInt(br.readLine());
        breakButton = new boolean[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                breakButton[Integer.parseInt(st.nextToken())] = true;
            }
        }

        min = Integer.MAX_VALUE;



    }
}