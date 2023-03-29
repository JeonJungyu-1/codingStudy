import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
// bfs

public class Main {
    static int K;
    static int R, C;
    static boolean[][][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int[] mDr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] mDc = {-2, -1, 1, 2, 2, 1, -1, -2};
    static class Node {
        int r, c, t, kCnt;

        public Node(int r, int c, int t, int kCnt) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.kCnt = kCnt;
        }
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();

    }
    private static void solve() {
        int result = explore();
        System.out.println(result);
    }


    private static int explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
          
                
                if (cur.r == R - 1 && cur.c == C - 1) {
                    return cur.t;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (!isInRange(nr, nc) || visited[nr][nc][cur.kCnt]) continue;
                    que.offer(new Node(nr, nc, cur.t + 1, cur.kCnt));
                    visited[nr][nc][cur.kCnt] = true;

                    
                }

                if (cur.kCnt < K) {
                    for (int d = 0; d < 8; d++) {
                        int nr = cur.r + mDr[d];
                        int nc = cur.c + mDc[d];
                        if (!isInRange(nr, nc) || visited[nr][nc][cur.kCnt + 1]) continue;
                        que.offer(new Node(nr, nc, cur.t + 1, cur.kCnt + 1));
                        visited[nr][nc][cur.kCnt + 1] = true;
                    }
                }
            }
        }

        return -1;
    }
    private static void mapCopy(int k) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j][k]) continue;
                visited[i][j][k] = visited[i][j][k - 1];
            }
        }
    }
    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C][K + 1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    for (int k = 0; k < K + 1; k++) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }
    }
}