import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 정수 a를 k로 만들기

public class Main {
    
    static StringBuilder sb;
    static int A, K;
    static class Number {
        int n, cnt;

        public Number(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int result) {
        System.out.println(result);
    }

    private static void solve() throws IOException {
        init();
        int result = bfs();
        print(result);
    }

    private static int bfs() {
        Queue<Number> que = new ArrayDeque<>();
        boolean[] visited = new boolean[K + 1];
        que.offer(new Number(A, 0));

        while (!que.isEmpty()) {
            Number cur = que.poll();
            
            if (cur.n > K) continue;
            
            if (visited[cur.n]) continue;
            visited[cur.n] = true;

            if (cur.n == K) {
                return cur.cnt;
            }

            que.offer(new Number(cur.n + 1, cur.cnt + 1));
            que.offer(new Number(cur.n * 2, cur.cnt + 1));
        }

        return 0;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}