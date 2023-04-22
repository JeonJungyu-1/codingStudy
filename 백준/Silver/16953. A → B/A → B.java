import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// A -> B

public class Main {
    
    static StringBuilder sb;
    static long A, B;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Long> que = new ArrayDeque<>();
        que.offer(A);
        int time = 1;
        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                long cur = que.poll();

                if (cur > B) continue;

                if (cur == B) {
                    return time;
                }

                que.offer(cur * 2);
                que.offer(cur * 10 + 1);

            }
            time++;

        }

        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}