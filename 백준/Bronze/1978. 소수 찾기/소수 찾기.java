import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number != 1 && isPrime(number)) cnt++;
        }

        System.out.println(cnt);
    }

    


    private static boolean isPrime(int number) {
        int sqrtNumber = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}