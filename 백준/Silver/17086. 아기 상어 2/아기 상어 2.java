import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int max;
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dc = {-1, 1, 0, 0, 1, -1, -1, 1};
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(max);
    }
    private static void solve() {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) continue;
                isVisited = new boolean[N][M];
                int cnt = explore(i, j);
                max = Math.max(cnt, max);
            }
        }
    }
    private static int explore(int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));
        isVisited[r][c] = true;
        int cnt = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                for (int d = 0; d < 8; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (!mapCheck(nr, nc) || isVisited[nr][nc]) continue;
                    if (map[nr][nc] == 1) return cnt;
                    isVisited[nr][nc] = true;
                    que.offer(new Node(nr, nc));
                }
            }
            cnt++;
        }
        return 0;
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}