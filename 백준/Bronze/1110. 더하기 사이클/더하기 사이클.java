import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 더하기 사이클

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
        int[] numbers = new int[3];
        Arrays.fill(numbers, -1);
        numbers[0] = N;
        numbers[1] = getSum(N);
        int cnt = 0;
        while (numbers[2] != N) {
            numbers[2] = (numbers[0] % 10) * 10 + (numbers[1] % 10);
            numbers[0] = numbers[2];
            numbers[1] = getSum(numbers[2]);
            cnt++;
        }

        System.out.println(cnt);

    }


    private static int getSum(int n) {
        int sum = 0;
        if (n < 10) n *= 10;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}