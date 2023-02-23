import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 알파벳
// 대문자 아스키 65 ~ 90

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int max;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    private static void solve() {
        max = Integer.MIN_VALUE;

        
        memo[map[0][0] - 65] = 1;
        explore(1, 0, 0);
        System.out.println(max);
        
    }

    private static void explore(int cnt, int r, int c) {
        max = Math.max(max, cnt);
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!mapcheck(nr, nc)) continue;
            if (memo[map[nr][nc] - 65] == 1) continue;
            memo[map[nr][nc] - 65] = 1;
            explore(cnt + 1, nr, nc);
            memo[map[nr][nc] - 65] = 0;
        }
    }
    private static boolean mapcheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        memo = new int[26];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j];
            }
        }

    }
}