import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 영단어 암기는 괴로워

public class Main {
    
    static StringBuilder sb;

    static class Word implements Comparable<Word> {
        String s; 
        int cnt;
        public Word(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Word o) {
            int compareCnt = Integer.compare(o.cnt, this.cnt);
            int compareLength = Integer.compare(o.s.length(), this.s.length());
            int compareStr = this.s.compareTo(o.s);
            return compareCnt != 0 ? compareCnt : compareLength != 0 ? compareLength : compareStr;
        }

    }
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

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }


        Queue<Word> pq = new PriorityQueue<>();
        for (String key : map.keySet()) {
            pq.offer(new Word(key, map.get(key)));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll().s).append("\n");
        }

        System.out.println(sb.toString());
    }
}