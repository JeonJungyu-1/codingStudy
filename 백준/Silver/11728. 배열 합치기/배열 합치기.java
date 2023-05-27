import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 배열 합치기

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
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }
}