package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10992 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                if (k == 0 || k == 2 * i) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 2 * number - 1; i++) {
            sb.append("*");
        }

        System.out.println(sb);
    }
}
