import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] number = new boolean[N + 1];
        
        int cnt = 0;
        int result = 0;
        outer:
        for (int i = 2; i <= N; i++) {
            if (number[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (!number[j]) {
                    number[j] = true;
                    cnt++;
                    if (cnt == K) {
                        result = j;
                        break outer;
                    }
                }
            }
        }

        System.out.println(result);
    }
}