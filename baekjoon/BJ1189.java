package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 컴백홈
// 백트래킹

public class BJ1189 {
    static StringBuilder sb;
    static int R, C, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int cnt;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        // (R - 1, 0) -> (0, C - 1)로 이동
        isVisited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

    }

    private static void dfs(int r, int c, int distance) {
        // 현재까지 간거리가 K보다 크면 return
        if (distance > K) return;

        // 집에 도착하면 return
        if (r == 0 && c == C - 1) {
            // 간 거리가 K일때 cnt 하나 증가
            if (distance == K) cnt++;    
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!isMapRange(nr, nc) || isVisited[nr][nc] || map[nr][nc] == 1) continue;
            isVisited[nr][nc] = true;
            dfs(nr, nc, distance + 1);
            isVisited[nr][nc] = false;
        }

    }

    private static boolean isMapRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (ch[j] == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        



    }
}
