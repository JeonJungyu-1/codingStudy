package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

// 빙산
// flood fill - bfs

public class BJ2573 {
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int time;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(time);
    }

    private static void solve() {

        time = 0;
        while (true) {
            int cnt = 0;
            isVisited = new boolean[N][M];

            // time이 지날때마다 빙산 높이 줄이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 || isVisited[i][j]) continue;
                    cnt++;
                    // 빙산이 2개로 나누어 지면 break
                    if (cnt >= 2) break;
                    isVisited[i][j] = true;
                    bfs(i, j);
                }
            }
            
            // 빙산이 하나도 없거나 2개이상으로 나누어졌을 때
            if (cnt != 1) {
                if (cnt == 0) time = 0;
                break;
            }

            time++;
        }
    }

    private static void bfs(int i, int j) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(i, j));
        isVisited[i][j] = true;
        
        while (!que.isEmpty()) {
            Node cur = que.poll();

            int zeroCount = 0;
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (!mapCheck(nr, nc) || isVisited[nr][nc]) continue;
                // 빙산 주위에 0이면 zeroCount 하나 증가
                if (map[nr][nc] == 0) {
                    zeroCount++;
                    continue;
                } else {
                    isVisited[nr][nc] = true;
                    que.offer(new Node(nr, nc));
                }

            }

            // zeroCount만큼 빙산 높이 줄이기
            if (map[cur.r][cur.c] <= zeroCount) {
                map[cur.r][cur.c] = 0;
            } else {
                map[cur.r][cur.c] -= zeroCount;
            }

        }
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
