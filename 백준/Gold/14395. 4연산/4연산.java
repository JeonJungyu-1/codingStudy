import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 4연산

public class Main {
    
    static StringBuilder sb;
    static int s, t;
    static class Number {
        long number;
        String operator;
        public Number(long number, String operator) {
            this.number = number;
            this.operator = operator;
        }

        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        if (s == t) {
            System.out.println(0);
            return;
        }
        bfs();

        print();
    }

    private static void bfs() {
        Queue<Number> que = new ArrayDeque<>();
        // boolean[] visited = new boolean[1000000001];
        Map<Long, Boolean> visited = new HashMap<>();
        que.offer(new Number(s, ""));
        while (!que.isEmpty()) {
            Number cur = que.poll();

            if (cur.number == t) {
                System.out.println(cur.operator);
                return;
            }

            if (cur.number < 1) continue;

            if (visited.getOrDefault(cur.number, false)) continue;
            visited.put(cur.number, true);
            


            que.offer(new Number(cur.number * cur.number, cur.operator + "*"));
            que.offer(new Number(cur.number + cur.number, cur.operator + "+"));
            que.offer(new Number(cur.number - cur.number, cur.operator + "-"));
            que.offer(new Number(cur.number / cur.number, cur.operator + "/"));

        }

        System.out.println(-1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}