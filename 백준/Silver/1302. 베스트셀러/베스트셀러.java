import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 베스트셀러

public class Main {
    
    static StringBuilder sb;
    static class Book implements Comparable<Book> {
        String subject;
        int cnt;
        public Book(String subject, int cnt) {
            this.subject = subject;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Book o) {
            int compareCnt = Integer.compare(o.cnt, this.cnt);
            return compareCnt != 0 ? compareCnt : this.subject.compareTo(o.subject);
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
        Queue<Book> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        for (String s : map.keySet()) {
            pq.offer(new Book(s, map.get(s)));
        }
       

        System.out.println(pq.poll().subject);


 
    }
}