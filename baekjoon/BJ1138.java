package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한 줄로 서기
// 구현

public class BJ1138 {
    static int N;
    static int[] numbers;
    static int[] direction;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int number : direction) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < numbers.length; i++) {
            int cnt = 0;
            for (int j = 0; j < direction.length; j++) {
                if (direction[j] == 0) {
                    if (cnt == numbers[i]) {
                        direction[j] = i + 1;
                        break;
                    } else {
                        cnt++;
                    }
                }
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        direction = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}