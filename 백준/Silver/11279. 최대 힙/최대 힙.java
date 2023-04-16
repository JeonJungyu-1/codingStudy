import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 최대 힙

public class Main {
    
    static StringBuilder sb;
    static int N;
    static Queue<Integer> pq;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(-pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(-number);
            }
        }

        System.out.println(sb.toString());

    }
}