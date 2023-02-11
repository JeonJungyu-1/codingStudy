package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 - bfs, 3차원 배열 활용(벽을 부순 부분과 부수지 않은 부분)
public class BJ2206 {
    static int N, M;
    static int[][] map;
    static int[][][] isVisited;
    static Queue<int []> wall;
    static Queue<int []> queue;
    static int shortDistance;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wall = new ArrayDeque<>();
        queue = new ArrayDeque<>();
        shortDistance = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
                // if (map[i][j] == 1) {
                //     wall.add(new int[]{i, j});
                // }
            }
        }

        // 1. 장애물을 하나씩 없애가면서 최단거리 탐색하기 - 시간초과 실패
        // while (!wall.isEmpty()) {
        //     isVisited = new int[N][M];
        //     queue.add(new int[] {0, 0});
        //     isVisited[0][0] = 1;
        //     int[] rc = wall.poll();
        //     map[rc[0]][rc[1]] = 0;
        //     bfsExplore();
        //     map[rc[0]][rc[1]] = 1;

        //     // 목적지에 도착했을때만 값 비교해서 최소거리 얻기
        //     if (isVisited[N - 1][M - 1] != 0) {
        //         shortDistance = Math.min(shortDistance, isVisited[N - 1][M - 1]);
        //     }
        // }

        // // 목적지에 한번도 도착하지 못했다면 -1
        // if (shortDistance == Integer.MAX_VALUE) {
        //     shortDistance = -1;
        // }


        // 2. 다른 접근방식 - 장애물 제거여부 체크하면서 bfs - 이건 벽을 부수고 간거하고 안부수고 간거를 전부 체크 못함 - 일부 반례 통과 못함(목적지 근처 벽으로 막혀있는 경우)
        // isVisited = new int[N][M];
        // queue.add(new int[] {0, 0, 1});
        // isVisited[0][0] = 1;
        
        // bfsExplore();

        // if (isVisited[N - 1][M - 1] == 0) {
        //     System.out.println(0);
        // } else {
        //     System.out.println(isVisited[N - 1][M - 1]);
        // }



        // 3. 3차원 배열로 벽을 부순 경우와 부수지 않은 경우 나누기
        isVisited = new int[N][M][2];
        queue.add(new int[] {0, 0, 1});
        isVisited[0][0][1] = 1;
        bfsExplore();

        int min = Math.max(isVisited[N-1][M -1][0], isVisited[N-1][M -1][1]);
        if (min == 0) {
            min = -1;
        }
        System.out.println(min);

        br.close();
    }


    // 3. bfs - 3차원 배열 이용
    private static void bfsExplore() {
        while (!queue.isEmpty()) {
            int[] rc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = rc[0] + dr[i];
                int nc = rc[1] + dc[i];
                // 맵을 벗어났거나 장애물을 만났거나 이미 방문한곳이면 다음 반복으로 넘거가기
                if (!mapCheck(nr, nc)) continue;
                if (map[nr][nc] == 1){
                    if (rc[2] == 1) {
                        queue.add(new int[] {nr, nc, 0});
                        isVisited[nr][nc][0] = isVisited[rc[0]][rc[1]][1] + 1;
                    } 
                    continue;
                } else {
                    if (rc[2] == 1 && isVisited[nr][nc][1] == 0) {
                        isVisited[nr][nc][1] = isVisited[rc[0]][rc[1]][1] + 1;
                        queue.add(new int[] {nr, nc, 1});
                        
                    } else if (rc[2] == 0 && isVisited[nr][nc][0] == 0) {
                        isVisited[nr][nc][0] = isVisited[rc[0]][rc[1]][0] + 1;
                        queue.add(new int[] {nr, nc, 0});
                    }
                }
                // 목적지에 도착했으면 반복 탈출
                if (nr == N - 1 && nc == M - 1) return;
            }
        }

    }



     // 2. bfs 이용해서 탐색 - 장애물 제거여부 체크
    //  private static void bfsExplore() {
    //     while (!queue.isEmpty()) {
    //         int[] rc = queue.poll();

    //         for (int i = 0; i < 4; i++) {
    //             int nr = rc[0] + dr[i];
    //             int nc = rc[1] + dc[i];
    //             // 맵을 벗어났거나 장애물을 만났거나 이미 방문한곳이면 다음 반복으로 넘거가기
    //             if (!mapCheck(nr, nc) || isVisited[nr][nc] != 0) continue;
    //             if (map[nr][nc] == 1){
    //                 if (rc[2] == 1) {
    //                     // rc[2] = 0;
    //                     isVisited[nr][nc] = isVisited[rc[0]][rc[1]] + 1;
    //                     queue.add(new int[] {nr, nc, 0});
    //                 }
    //                 continue;
    //             }
    //             isVisited[nr][nc] = isVisited[rc[0]][rc[1]] + 1;
    //             // 목적지에 도착했으면 반복 탈출
    //             if (nr == N - 1 && nc == M - 1) return;
    //             queue.add(new int[] {nr, nc, rc[2]});
    //         }
    //     }

    // }


    // 1. bfs 이용해서 탐색 - 시간초과 실패
    // private static void bfsExplore() {
    //     while (!queue.isEmpty()) {
    //         int[] rc = queue.poll();

    //         for (int i = 0; i < 4; i++) {
    //             int nr = rc[0] + dr[i];
    //             int nc = rc[1] + dc[i];
    //             // 맵을 벗어났거나 장애물을 만났거나 이미 방문한곳이면 다음 반복으로 넘거가기
    //             if (!mapCheck(nr, nc) || map[nr][nc] != 0 || isVisited[nr][nc] != 0) continue;
    //             isVisited[nr][nc] = isVisited[rc[0]][rc[1]] + 1;
    //             // 목적지에 도착했으면 반복 탈출
    //             if (nr == N - 1 && nc == M - 1) return;
    //             queue.add(new int[] {nr, nc});
    //         }
    //     }
    //     queue.clear();

    // }


    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
