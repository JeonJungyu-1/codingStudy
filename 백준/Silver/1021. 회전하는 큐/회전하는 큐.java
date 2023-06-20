import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 회전하는 큐

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            int cnt = 0;
            
            while (true) {
                if (deque.peekFirst() == number) {
                    cnt = Math.min(cnt, deque.size() - cnt);
                    deque.poll();
                    break;
                }
                deque.addFirst(deque.pollLast());
                cnt++;
            }
            result += cnt;
        }

        System.out.println(result);



    }
}