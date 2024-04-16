import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 아시아 정보올림피아드

public class Main {
    
    static StringBuilder sb;
    static class Student implements Comparable<Student> {
        int country, student, score;

        public Student(int country, int student, int score) {
            this.country = country;
            this.student = student;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.score, this.score);
        }
        
        

    }
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


        Queue<Student> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        } 

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            Student cur = pq.poll();
            if (map.getOrDefault(cur.country, 0) >= 2) {
                i--;
                continue;
            }

            map.put(cur.country, map.getOrDefault(cur.country, 0) + 1);
            sb.append(cur.country).append(" ").append(cur.student).append("\n");
        }

        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}