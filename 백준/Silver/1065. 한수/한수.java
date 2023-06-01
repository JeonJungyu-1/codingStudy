import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한수

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() throws IOException {
        init();
        outer:
        for (int i = 1; i <= N; i++) {
            int number = i;
            int prev = number % 10;
            number /= 10;

            int current = number % 10;
            number /= 10;
            
            int diff = prev - current;
            while (number != 0) {
                prev = current;
                current = number % 10;
                number /= 10;
                if ((prev - current) != diff) {
                    continue outer;
                }
            }
            count++;
        }
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

    }
}