import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int[] memo;
    static int min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];


        explore();
        System.out.println(min);
    }
    private static void explore() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(N);
        memo[N] = 1;
        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                if (cur == 1) return;
                if (cur % 3 == 0 && cur / 3 > 0 && memo[cur / 3] == 0) {
                    que.offer(cur / 3);
                    memo[cur / 3] = 1;
                }
                if (cur % 2 == 0 && cur / 2 > 0 && memo[cur / 2] == 0) {
                    que.offer(cur / 2);
                    memo[cur / 2] = 1;
                }
                if (cur - 1 > 0  && memo[cur - 1] == 0) {
                    que.offer(cur - 1);
                    memo[cur - 1] = 1;
                }

            }
            min++;
        }
    }
}