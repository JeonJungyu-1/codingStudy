import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 점수 계산

public class Main {
    
    static StringBuilder sb;

    static class Problem implements Comparable<Problem> {
        int index, score;

        public Problem(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Problem o) {
            int compareSore = Integer.compare(o.score, this.score);
            return compareSore != 0 ? compareSore : Integer.compare(this.index, o.index);
        }

        
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        Queue<Problem> que = new PriorityQueue<>();
        for (int i = 1; i <= 8; i++) {
            que.offer(new Problem(i, Integer.parseInt(br.readLine())));
        }
        
        int total = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            total += que.peek().score;
            pq.offer(que.poll().index);
        }

        sb.append(total).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
}