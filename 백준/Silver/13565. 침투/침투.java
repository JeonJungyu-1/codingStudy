import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 침투
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
    
    private static void print() {
        boolean isAvailable = false;
        for (int i = 0; i < M; i++) {
            if (visited[N - 1][i]) isAvailable = true;
        }

        System.out.println(isAvailable ? "YES" : "NO");

    }

    private static void solve() throws IOException {
        init();
        for (int i = 0; i < M; i++) {
            if (map[0][i] == 1) continue;
            dfs(0, i);
        }
        print();
    }

    private static void dfs(int r, int c) {
        if (visited[r][c]) return;
        visited[r][c] = true;


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc) || map[nr][nc] == 1) continue;
            dfs(nr, nc);
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
                map[i][j] = ch[j] == '0' ? 0 : 1;
            }
        }


    }
}