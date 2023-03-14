import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐

public class Main {
    static StringBuilder sb;
    static int T, N, M;
    static Queue<Integer> que;
    public static void main(String[] args) throws IOException {
        init();
    }
    


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            que = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            int cnt = solve();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }



    private static int solve() {
        int cnt = 1;
        while (true) {

            int high = Integer.MIN_VALUE;
            int size = que.size();

            for (int i = 0; i < size; i++) {
                high = Math.max(que.peek(), high);
                que.offer(que.poll());
            }

            if (high == que.peek()) {
                if (M == 0) {
                    return cnt;
                } else {
                    cnt++;
                    que.poll();
                }
            } else {
                que.offer(que.poll());
            }

            M--;
            if (M < 0) M = size - 1;
        }
    }
}