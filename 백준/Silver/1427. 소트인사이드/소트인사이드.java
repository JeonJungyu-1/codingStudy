import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 소트인사이드

public class Main {
    
    static StringBuilder sb;
    static Queue<Integer> pq;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
   

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        pq = new PriorityQueue<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            pq.offer('0' - str.charAt(i));
        }

        while (!pq.isEmpty()) {
            sb.append(-pq.poll());
        }

        System.out.println(sb.toString());
    }
}