import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 카드1

public class Main {
    
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            que.offer(i + 1);
        }
        while (!que.isEmpty()) {
            sb.append(que.poll()).append(" ");
            if (!que.isEmpty()) que.offer(que.poll());
        }
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}