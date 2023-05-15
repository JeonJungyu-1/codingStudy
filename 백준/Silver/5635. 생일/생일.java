import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 생일

public class Main {
    
    static StringBuilder sb;
    static class Student implements Comparable<Student> {
        String name;
        int d, m, y;
        public Student(String name, int d, int m, int y) {
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }

        @Override
        public int compareTo(Student o) {
            int compareY = Integer.compare(this.y, o.y);
            int compareM = Integer.compare(this.m, o.m);
            return this.y != o.y ? compareY : this.m != o.m ? compareM : Integer.compare(this.d, o.d);
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
        Student[] list = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[i] = new Student(n, d, m, y);
        }

        Arrays.sort(list);
        sb.append(list[N - 1].name).append("\n").append(list[0].name);
        System.out.println(sb.toString());

    }
}