import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 과목선택

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
        int sum = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        pq.poll();
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        
        for (int i = 0; i < 2; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }



        pq.poll();
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}