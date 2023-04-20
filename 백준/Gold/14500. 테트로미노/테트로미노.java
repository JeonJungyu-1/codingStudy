import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 테트로미노

public class Main {
    static int N, M;

    static int[][] map;
    static boolean[][] visited;
    static int max;
    static int maxNumber;

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(0, i, j, 0);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }





    private static void dfs(int cnt, int r, int c, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        if (max >= maxNumber * (4 - cnt) + sum) return;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!isInRange(nr, nc) || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(cnt + 1, nr, nc, sum + map[nr][nc]);

            if (cnt == 2) {
                int nd = (d + 1) % 4;
                int nnr = r + dr[nd];
                int nnc = c + dc[nd];
                if (isInRange(nnr, nnc) && !visited[nnr][nnc]) {
                    dfs(cnt + 2, nr, nc, sum + map[nr][nc] + map[nnr][nnc]);
                }
            }
            visited[nr][nc] = false;
        }
    }





    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }





    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxNumber = Math.max(maxNumber, map[i][j]);
            }
        }

        max = Integer.MIN_VALUE;
        
    }
}