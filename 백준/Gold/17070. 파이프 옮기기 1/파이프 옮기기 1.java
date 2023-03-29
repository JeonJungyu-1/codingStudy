import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
// dfs or dp
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    static int count;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        
        
    }
    private static void solve() {
        count = 0;
        visited[1][2] = true;
        explore(0, 1, 2, 0);
        System.out.println(count);
    }


    private static void explore(int cnt, int r, int c, int preD) {
        if (preD == 1 && isInRange(r, c) && (map[r - 1][c] == 1 || map[r][c - 1] == 1)) return;
        if (r == N && c == N) {
            count++;
            return;
        }
        
        switch (preD) {
            case 0:
                for (int i = 0; i < 2; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!isInRange(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    explore(cnt + 1, nr, nc, i);
                    visited[nr][nc] = false;
                }
                break;
            case 1:
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!isInRange(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    explore(cnt + 1, nr, nc, i);
                    visited[nr][nc] = false;
                }
                break;
            case 2:
                for (int i = 1; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!isInRange(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    explore(cnt + 1, nr, nc, i);
                    visited[nr][nc] = false;
                }
                break;
        
        }

        
        


    }
    private static boolean isInRange(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}