import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모든 순열

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static boolean result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        do {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");

        } while(np(N -1));
    }

    private static boolean np(int size) {
        int i = size;
        while (i > 0 && numbers[i - 1] > numbers[i]) i--;
        if (i == 0) return false;

        int j = size;
        while (numbers[i - 1] > numbers[j]) j--;
        int temp = numbers[i - 1];
        numbers[i - 1] = numbers[j];
        numbers[j] = temp;

        int k = size;
        while (i < k) {
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
            i++;
            k--;
        }

        return true;
    }
    

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}