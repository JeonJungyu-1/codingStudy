import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 2

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        Deque<Integer> que = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    que.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (que.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(que.poll());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (que.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(que.peekFirst());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (que.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(que.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}