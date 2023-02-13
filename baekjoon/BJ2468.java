package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역 - dfs, bfs
public class BJ2468 {
    static int N;
    static int[][] map;
    static int height;
    static int safe;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max;
    static int maxRain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxRain = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxRain = Math.max(maxRain, map[i][j]);
            }
        }


        // 높이 증가시키면서 최대 안전지역이 나올 때까지
        height = 1;
        max = 1;

        while (true) {
            if (height > maxRain) break;
            safe = 0;
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && !isVisited[i][j]) {
                        // bfs(i, j, height);
                        dfs(i, j, height);
                        safe++;
                    }
                }
            }
            
            if (safe > max) {
                max = safe;
            }
            height++;


        }

        // if (maxRain == 0) {
        //     max = 1;
        // }

        System.out.println(max);
    }
    private static void bfs(int rr, int cc, int height) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(rr, cc));
        isVisited[rr][cc] = true;

        while (!que.isEmpty()) {
            Node n = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] <= height || isVisited[nr][nc]) continue;
                que.offer(new Node(nr, nc));
                isVisited[nr][nc] = true;
            }
        }
    }

    private static void dfs(int r, int c, int height) {
        if (isVisited[r][c]) return;
        isVisited[r][c] = true;


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!mapCheck(nr, nc) || map[nr][nc] <= height || isVisited[nr][nc]) continue;
            dfs(nr, nc, height);
            isVisited[nr][nc] = true;
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
