import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 30
// 그리디

public class Main {
    
    static StringBuilder sb;
    static List<Integer> numbers;
    static boolean hasZero;
    static long sum;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();
        
        if (hasZero && sum % 3 == 0) {
            Collections.sort(numbers);
            for (int i = numbers.size() - 1; i >= 0; i--) {
                sb.append(numbers.get(i));
            }
        } else {
            sb.append(-1);
        }


        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        numbers = new ArrayList<>();
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int number = ch[i] - '0';
            numbers.add(number);
            if (number == 0) {
                hasZero = true;
            } else {
                sum += number;
            }
        }

    }
}