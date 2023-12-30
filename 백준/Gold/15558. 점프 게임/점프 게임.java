import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프 게임

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static int[][] map;
    static class User {
        int index, order, time;

        public User(int index, int order, int time) {
            this.index = index;
            this.order = order;
            this.time = time;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        boolean[][] visited = new boolean[2][N];
        Queue<User> que = new ArrayDeque<>();
        que.offer(new User(0, 0, 0));
    
        while (!que.isEmpty()) {
            User cur = que.poll();
            
            if (cur.index >= N) {
                System.out.println(1);
                return;
            }


            if (cur.index < 0 || map[cur.order][cur.index] == 0 || cur.index < cur.time) continue;
            

            if (visited[cur.order][cur.index]) continue;
            visited[cur.order][cur.index] = true;

            que.offer(new User(cur.index + 1, cur.order, cur.time + 1));
            que.offer(new User(cur.index - 1, cur.order, cur.time + 1));
            que.offer(new User(cur.index + K, (cur.order + 1) % 2, cur.time + 1 ));


        }

        System.out.println(0);

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2][N];

        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            map[0][i] = ch[i] - '0';
        }

        ch = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            map[1][i] = ch[i] - '0';
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}