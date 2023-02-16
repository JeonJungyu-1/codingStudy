import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 적록색약 - dfs, bfs
public class Main {
    static int N;
    static char[][] dfsMap;
    static char[][] bfsMap;
    static boolean[][] isVisited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dfsMap = new char[N][N];
        bfsMap = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                dfsMap[i][j] = ch[j];
                bfsMap[i][j] = ch[j] == 'G' ? 'R' : ch[j];
            }
        }

        // 적록색약이 아닌 사람 - dfs
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                dfs(i, j, dfsMap[i][j]);
                cnt++;
            }
        }

        sb.append(cnt).append(" ");


        // 적록색약인 사람 - bfs
        cnt = 0;
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                bfs(i, j, bfsMap[i][j]);
                cnt++;
            }
        }

        sb.append(cnt);
        

        System.out.println(sb.toString());




        br.close();
    }

    // 적록색약이 아닌 사람 - dfs
    static void dfs(int r, int c, char color) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!mapCheck(nr, nc) || dfsMap[nr][nc] != color || isVisited[nr][nc]) continue;
            isVisited[nr][nc] = true;
            dfs(nr, nc, color);
        }
    }

    // 적록색약인 사람 - bfs
    static void bfs(int r, int c, char color) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(r, c));

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || bfsMap[nr][nc] != color || isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                que.add(new Node(nr, nc));
            }
        }

    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
}
