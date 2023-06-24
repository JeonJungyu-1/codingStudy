import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 직각삼각형
// 구현

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;
            pq.clear();
            pq.offer(a);
            pq.offer(b);
            pq.offer(c);
            if (isRightTriangle(pq)) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static boolean isRightTriangle(Queue<Integer> pq) {
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();
        if (((a * a) + (b * b)) == (c * c)) return true;
        return false;
    }
}