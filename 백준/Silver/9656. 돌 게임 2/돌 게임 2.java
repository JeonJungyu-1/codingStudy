import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 돌 게임 2

public class Main {

    static class Stone {
        int index, cnt;

        public Stone(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
        
    }

    static int N;
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int result) {
        System.out.println(result % 2 == 0 ? "SK" : "CY");

    }

    private static void solve() throws IOException {
        init();

        int result = bfs();

        print(result);
    }

    private static int bfs() {
        Queue<Stone> que = new ArrayDeque<>();
        que.offer(new Stone(0, N));
        boolean[] visited = new boolean[N + 1];

        while (!que.isEmpty()) {
            Stone cur = que.poll();
            if (cur.cnt < 0) continue;
            if (visited[cur.cnt]) continue;
            visited[cur.cnt] = true;

            if (cur.cnt == 0) {
                return cur.index;
            }

            que.offer(new Stone(cur.index + 1, cur.cnt - 1));
            que.offer(new Stone(cur.index + 1, cur.cnt - 3));
        }

        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}