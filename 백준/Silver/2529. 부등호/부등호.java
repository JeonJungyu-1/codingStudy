import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부등호
// 브루트포스, 백트래킹

public class Main {
    
    static StringBuilder sb;
    static int K;
    static String[] sign;
    static int[] numbers;
    static boolean[] visited;
    static long max, min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        String sMin = String.valueOf(min);
        String sMax = String.valueOf(max);
        if (String.valueOf(min).length() == K) {
            sMin = "0" + sMin;
        }

        if (String.valueOf(max).length() == K) {
            sMax = "0" + sMax;
        }

        sb.append(sMax).append("\n").append(sMin);
        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            numbers[0] = i;
            explore(1, i);
            visited[i] = false;
        }
    }

    private static void explore(int cnt, int pre) {
        if (cnt == K + 1) {
            Long number = 0L;
            for (int i = 0; i < numbers.length; i++) {
                number = (number * 10) + numbers[i];
            }

            min = Math.min(min, number);
            max = Math.max(max, number);
            return;
        }


        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            switch (sign[cnt - 1]) {
                case "<":
                    if (pre < i) {
                        visited[i] = true;
                        numbers[cnt] = i;
                        explore(cnt + 1, i);
                        visited[i] = false;
                    }
                    break;
                case ">":
                    if (pre > i) {
                        visited[i] = true;
                        numbers[cnt] = i;
                        explore(cnt + 1, i);
                        visited[i] = false;
                    }
                    
                    break;
            }

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");
        numbers = new int[K + 1];
        visited = new boolean[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
    }
}