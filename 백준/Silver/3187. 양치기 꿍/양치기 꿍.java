import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 양치기 꿍
// bfs

public class Main {
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        init();
        int wolf = 0;
        int sheep = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || map[i][j] == 1) continue;
                int[] result = bfs(i, j);
                wolf += result[0];
                sheep += result[1];
            }
        }
        print(wolf, sheep);
    }

    private static void print(int wolf, int sheep) {
        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb.toString());
    }

    private static int[] bfs(int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));

        int wolf = 0;
        int sheep = 0;

        while (!que.isEmpty()) {

            Node cur = que.poll();

            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;

            if (map[cur.r][cur.c] == 2) {
                wolf++;
            } else if (map[cur.r][cur.c] == 3) {
                sheep++;
            }
            

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || map[nr][nc] == 1) continue;                
                que.offer(new Node(nr, nc));
            }

        }


        if (wolf < sheep) {
            wolf = 0;
        } else {
            sheep = 0;
        }

        int[] result = {wolf, sheep};
        return result;
        
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == '.') {
                    map[i][j] = 0;
                } else if (ch[j] == '#') {
                    map[i][j] = 1;
                } else if (ch[j] == 'v') {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
        }

  
    }
}