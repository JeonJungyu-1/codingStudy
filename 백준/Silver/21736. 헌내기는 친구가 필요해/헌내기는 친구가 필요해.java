import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해

public class Main {
    
    static StringBuilder sb;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][] map;
    static Node start;
    static int N, M;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == 'O') {
                    map[i][j] = 0;
                } else if (ch[j] == 'P') {
                    map[i][j] = 1;
                } else if (ch[j] == 'X') {
                    map[i][j] = -1;
                } else if (ch[j] == 'I') {
                    start = new Node(i, j);
                    map[i][j] = -1;
                }
            }
        }


        int cnt = bfs();

        System.out.println(cnt == 0 ? "TT" : cnt);
    }


    private static int bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(start);
        int cnt = 0;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || map[nr][nc] == -1) continue;

                if (map[nr][nc] == 1) {
                    cnt++;
                }

                map[nr][nc] = -1;

                que.offer(new Node(nr, nc));

            }
        }

        return cnt;
    }


    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}