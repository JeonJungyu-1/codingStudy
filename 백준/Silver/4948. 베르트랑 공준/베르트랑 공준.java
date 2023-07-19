import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 베르트랑 공준
// 소수

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) break;
            list.add(number);
            max = Math.max(number, max);
        }

        boolean[] numbers = new boolean[max * 2 + 1];
        numbers[1] = true;

        int sqrtNumber = (int)Math.sqrt(max * 2);
        for (int i = 2; i <= sqrtNumber; i++) {
            if (numbers[i]) continue;
            for (int j = i * i; j <= max * 2; j += i) {
                numbers[j] = true;
            }

        }

        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            for (int j = list.get(i) + 1; j <= list.get(i) * 2; j++) {
                if (!numbers[j]) cnt++;
            }
            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());





        


    }
}