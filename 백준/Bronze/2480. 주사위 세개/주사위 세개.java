import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 세개

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int[] numbers = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int money = 0;
        if (numbers[0] == numbers[1]) {
            if (numbers[1] == numbers[2]) {
                money = 10000 + (numbers[0] * 1000);
            } else {
                money = 1000 + (numbers[0] * 100);
            }
        } else {
            if (numbers[1] == numbers[2]) {
                money = 1000 + (numbers[1] * 100);
            } else {
                money = numbers[2] * 100;
            }
        }

        System.out.println(money);


    }
}