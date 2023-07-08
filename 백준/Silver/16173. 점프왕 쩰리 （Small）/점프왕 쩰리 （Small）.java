import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점프왕 쩰리 (small)
// dfs

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static String result;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(result.length() > 0 ? result : "Hing");
    }

    private static void solve() throws IOException {
        init();
        result = "";
        dfs(0, 0);
        print();
    }

    private static void dfs(int r, int c) {
        if (result.length() > 0 || map[r][c] == 0) return;
        if (r == N - 1 && c == N - 1) {
            result = "HaruHaru";
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = r + (dr[i] * map[r][c]);
            int nc = c + (dc[i] * map[r][c]);
            if (!isInRange(nr, nc)) continue;
            dfs(nr, nc); 
            if (result.length() > 0) return;
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}