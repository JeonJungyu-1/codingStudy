import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바닥장식
// dfs

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int cnt) {
        System.out.println(cnt);
    }

    private static void solve() throws IOException {
        init();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j], map[i][j]);
                    cnt++;
                }
            }
        }
        print(cnt);
    }

    private static void dfs(int r, int c, int d, int type) {

        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int i = 0; i < 2; i++) {
            int nr = r + dr[d + i];
            int nc = c + dc[d + i];
            if (!isInRange(nr, nc) || map[nr][nc] != type) continue;
            dfs(nr, nc, d, type);
        }
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
                map[i][j] = ch[j] == '-' ? 0 : 2;
            }
        }



    }
}