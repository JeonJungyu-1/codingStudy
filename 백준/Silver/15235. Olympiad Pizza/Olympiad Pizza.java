import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Olympiad Pizza


public class Main {
    
    static StringBuilder sb;
    static class Person implements Comparable<Person> {
        int index;
        int number;
        int time;
        public Person(int index, int number, int time) {
            this.index = index;
            this.number = number;
            this.time = time;
        }
        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.index, o.index);
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
        st = new StringTokenizer(br.readLine());
        Queue<Person> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            que.offer(new Person(i, Integer.parseInt(st.nextToken()), 0));
        }
        Queue<Person> pq = new PriorityQueue<>();
        int cnt = 1;
        while (!que.isEmpty()) {
            Person cur = que.poll();
            cur.number--;
            if (cur.number == 0) {
                cur.time = cnt;
                pq.offer(cur);
            } else {
                que.offer(cur);
            }
            cnt++;
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll().time).append(" ");
        }

        System.out.println(sb.toString());
    }
}