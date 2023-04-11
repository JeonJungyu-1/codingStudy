import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영화감독 숌

public class Main {
    
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int number) {
        System.out.println(number);
    }

    private static void solve() throws IOException {
        init();
        int cnt = 0;
        int number = 665;
        while (cnt < N) {
            number++;
            if (Integer.toString(number).indexOf("666") != -1) {
                cnt++;
            }
        }
        print(number);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
    }
}