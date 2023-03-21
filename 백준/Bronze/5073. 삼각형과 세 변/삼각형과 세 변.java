import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            if (numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0) break;

            Arrays.sort(numbers);
            if (numbers[0] + numbers[1] <= numbers[2]) {
                sb.append("Invalid").append("\n");
            } else if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
                sb.append("Equilateral").append("\n");
            } else if (numbers[0] == numbers[1] || numbers[1] == numbers[2]) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}