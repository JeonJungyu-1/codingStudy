import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 숫자판 점프
// dfs

public class Main {
    
    static StringBuilder sb;
    static int[][] map;
    static Set<String> set = new HashSet<>();
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(set.size());
    }

    private static void solve() throws IOException {
        init();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j, "");
            }
        }

        print();
    }

    private static void dfs(int cnt, int r, int c, String str) {
        
        if (cnt == 6) {
            set.add(str);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc)) continue;
            dfs(cnt + 1, nr, nc, str + map[nr][nc]);
        }




    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}