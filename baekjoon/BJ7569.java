package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 - bfs
public class BJ7569 {
    static int N, M, H;
    static int[][][] map;
    static int[][][] visit;
    static int[] dr = {0, 0, 0, 0, -1, 1};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static Queue<Node> que;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[M][N][H];
        visit = new int[M][N][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        que = new ArrayDeque<>();
        max = -1;
        int zero = 0;

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 익은 토마토가 있는 경우에만 큐에 저장
                    if (map[i][j][k] == 1) {
                        que.offer(new Node(i, j, k));
                        visit[i][j][k] = 1;
                        // 익지않은 토마토가 하나라도 있는지 확인
                    } else if (map[i][j][k] == 0){
                        zero = 1;
                    }
                }
            }
        }

        if (zero == 0) {
            max = 0;
        } else {
            explore();
            result();
        }
       
        

        System.out.println(max);


        br.close();
    }

    static void result() {
        a:
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 익지 않은 토마토가 하나라도 있고, 장애물이 아닐 때
                    if (visit[i][j][k] == 0 && map[i][j][k] != -1) {
                        max = -1;
                        break a;
                    }
                    max = Math.max(max, visit[i][j][k] - 1);
                }
            }
        }

        // for (int k = 0; k < H; k++) {
        //     for (int i = 0; i < M; i++) {
        //         for (int j = 0; j < N; j++) {
        //             System.out.print(visit[i][j][k] + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
            
        // }
    }

    static void explore() {
        while (!que.isEmpty()) {
            Node node = que.poll();

            // 상하좌우위아래 탐색
            for (int i = 0; i < 6; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                int nh = node.h + dh[i];
                // 맵을 벗어났거나 익지않은 토마토가 아니거나 이미 방문한 토마토일때 continue
                if (!mapCheck(nr, nc, nh) || map[nr][nc][nh] != 0 || visit[nr][nc][nh] > 0) continue;
                que.offer(new Node(nr, nc, nh));
                visit[nr][nc][nh] = visit[node.r][node.c][node.h] + 1;
            }
        }
    }

    static boolean mapCheck(int r, int c, int h) {
        return r >= 0 && r < M && c >= 0 && c < N && h >= 0 && h < H;
    }

    static class Node {
        int r;
        int c;
        int h;
        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

    }
}
