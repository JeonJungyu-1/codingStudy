import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 덱

public class Main {
    
    static StringBuilder sb;
    static Deque<Integer> dq = new ArrayDeque<>();
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int x;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                    
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;

                case "pop_front":
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;
            }
            
        }

        System.out.println(sb.toString());



    }
}