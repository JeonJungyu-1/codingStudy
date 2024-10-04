import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 삼각형 분류

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
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] numbers = new int[3];
            for (int j = 0; j < 3; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);
            sb.append("Case #").append(i + 1).append(": ");
            if (numbers[0] + numbers[1] <= numbers[2]) {
                sb.append("invalid!");
            } else {
                if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
                    sb.append("equilateral");
                } else if (numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0]) {
                    sb.append("isosceles");
                } else {
                    sb.append("scalene");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}