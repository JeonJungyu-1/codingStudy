import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 팀 나누기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        Queue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int A = 0;
        int B = 0;
        A += pq.poll();
        B += pq.poll();
        B += pq.poll();
        A += pq.poll();

        System.out.println(Math.abs(A - B));


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}