package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6603 {
    static int[] numbers;
    static int[] lottoNumbers;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;
            st = new StringTokenizer(input, " ");
            N = Integer.parseInt(st.nextToken());
            M = 6;
            numbers = new int[N];
            lottoNumbers = new int[6];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            combi(0, 0);
            sb.append("\n");
        }

            System.out.println(sb.toString());

    }

    // 순서 상관없으니 조합
    static void combi(int count, int start) {
        if (count == M) {
            for (int number: lottoNumbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            lottoNumbers[count] = numbers[i];
            combi(count + 1, i + 1);
            lottoNumbers[count] = 0;
        }


    }
}
