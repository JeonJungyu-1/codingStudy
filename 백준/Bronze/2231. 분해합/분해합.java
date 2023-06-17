import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분해합

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        String in = br.readLine();
        int length = in.length();
        int N = Integer.parseInt(in);
        int result = 0;
        int start = N - length * 9;
        for (int i = start; i <= N; i++) {
            int sum = i + getSum(i);
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }


    private static int getSum(int number) {
        int result = 0;
        while (number != 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }
}