import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 시리얼 번호

public class Main {
    
    static StringBuilder sb;
    static class Serial implements Comparable<Serial> {
        String str;
        int num;

        

        public Serial(String str) {
            this.str = str;
            this.num = 0;
            for (int i = 0 ; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    this.num += (str.charAt(i) - 48);
                }
            }

        }



        @Override
        public int compareTo(Serial o) {
            int compareLength = Integer.compare(this.str.length(), o.str.length());
            int compareNumber = Integer.compare(this.num, o.num);
            return compareLength != 0 ? compareLength : compareNumber != 0 ? compareNumber : this.str.compareTo(o.str);
        }

        

    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
 

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Serial> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(new Serial(br.readLine()));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll().str).append("\n");
        }

        System.out.println(sb.toString());
    }
}