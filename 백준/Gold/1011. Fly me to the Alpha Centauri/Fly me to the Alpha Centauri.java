import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각 거리에 대해 횟수 규칙 찾기
public class Main {
    static int N;
    static long x, y;
    static boolean isSuccess;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());
            int n = 0;
            
            // 1번 반복문때문에 시간초과
            // while (true) {
            //     if (y - x <= n * (n + 1)) break;
            //     n++;
            // }
            // if (y - x <= n * n) {
            //     answer = n * 2 - 1;
            // } else {
            //     answer = n * 2;
            // }

            // 2번 규칙 이용
            answer = (long)(Math.sqrt(4 * (y - x) - 1));

            sb.append(answer).append("\n");
        } 

        System.out.println(sb.toString());
    }


}

