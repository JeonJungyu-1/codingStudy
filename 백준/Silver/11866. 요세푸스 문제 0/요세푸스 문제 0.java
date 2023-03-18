import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제 0

public class Main {
    static StringBuilder sb;
    static int N, K;
    static Queue<Integer> que;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        sb.append("<");
        while (!que.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                que.offer(que.poll());
            }

            sb.append(que.poll()).append(que.isEmpty() ? "" : ", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }
    }
}