import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 오큰수

public class Main {
    
    static StringBuilder sb;
    static int N;
    static Queue<Number> que;
    static Queue<Number> pq;
    static int[] result;

    static class Number implements Comparable<Number> {
        int index, num;

        public Number(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.num, o.num);
        }
        
        

    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static void solve() throws IOException {
        init();
        pq.offer(new Number(que.peek().index, que.poll().num));
        while (!que.isEmpty()) {
            Number cur = que.poll();


            while (!pq.isEmpty() && cur.num > pq.peek().num) {
                Number next = pq.poll();
                result[next.index] = cur.num;
            }

            pq.offer(cur);


        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        que = new ArrayDeque<>();
        pq = new PriorityQueue<>();
        result = new int[N];
        Arrays.fill(result, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            que.offer(new Number(i, Integer.parseInt(st.nextToken())));
        }

    
    }
}