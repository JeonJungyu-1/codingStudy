import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Simple Collatz Sequence

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

        long n = Long.parseLong(br.readLine());

        long cnt = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n += 1;
            }
            cnt++;
        }

        System.out.println(cnt);




    }
}