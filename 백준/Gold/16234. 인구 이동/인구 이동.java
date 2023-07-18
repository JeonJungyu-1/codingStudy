import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//인구 이동

public class Main {
    
    static StringBuilder sb;
    static int N, L, R;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();

        boolean[][] visited = new boolean[N][N];
        boolean isEnd = true;
        int cnt = 0;
        while (true) {

            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }
            isEnd = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) { 
                    if (visited[i][j]) continue;
                    if (!bfs(i, j, visited)) isEnd = false;
                }
            }

            if (isEnd) break;
            cnt++;

        }

        System.out.println(cnt);
    }

    private static boolean bfs(int r, int c, boolean[][] visited) {
        Queue<Node> que = new ArrayDeque<>();
        Queue<Node> temp = new ArrayDeque<>();
        que.offer(new Node(r, c));

        int sum = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;
            temp.offer(new Node(cur.r, cur.c));
            sum += map[cur.r][cur.c];


            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc)) continue;
                int diff = Math.abs(map[nr][nc] - map[cur.r][cur.c]);
                if (diff < L || diff > R) continue;
                que.offer(new Node(nr, nc));
            }
        }

        sum /= temp.size();
        boolean isEnd = temp.size() > 1 ? false : true;
        
        while (!temp.isEmpty()) {
            Node cur = temp.poll();
            map[cur.r][cur.c] = sum;
        }


        return isEnd;


    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}