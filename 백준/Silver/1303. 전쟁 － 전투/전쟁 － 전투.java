import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전쟁 - 전투
// dfs

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int[] result) {
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        int[] count = new int[2];
        int[] result = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int color = map[i][j];
                dfs(i, j, color, count);
                result[color] += (count[color] * count[color]);
                count[color] = 0;
            }
        }
        print(result);
    }

    private static void dfs(int r, int c, int color, int[] count) {

        if (visited[r][c]) return;
        visited[r][c] = true;
        count[color]++;


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc) || map[nr][nc] != color) continue;
            dfs(nr, nc, color, count);
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] == 'W' ? 0 : 1;
            }
        }
    }
}