import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 거스름돈

public class Main {
    
    static StringBuilder sb;
    static int n, count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() throws IOException {
        init();
        count = -1;
        for (int i = n/5; i >= 0; i--) {
            int newNumber = n - (i * 5);
            if (newNumber % 2 == 0) {
                count = i + newNumber / 2;
                break;
            }
        }
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());


    }
}