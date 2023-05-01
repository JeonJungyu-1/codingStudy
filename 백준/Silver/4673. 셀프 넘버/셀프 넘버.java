import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 셀프 넘버

public class Main {
    
    static StringBuilder sb;
    static boolean[] numbers;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i]) sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i]) {
                selfNumber(i);
            }
        }
        print();
    }

    private static void selfNumber(int number) {
        int next = number;
        while (next < numbers.length) {
            
            number = next;
            while (number > 0) {
                next += (number % 10);
                number /= 10;
            }
            if (next < numbers.length) numbers[next] = true;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        numbers = new boolean[10001];   
    }
}