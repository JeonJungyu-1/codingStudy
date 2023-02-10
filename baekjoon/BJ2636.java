package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//치즈 - bfs, 테두리 탐색할 때 0인 부분을 공기로 보고, 공기 부분과 맞닿아 있는 부분을 탐색하기
public class BJ2636 {
    static int N, M;    
    static int[][] map;
    static boolean[][] isVisited;
    static int time;
    static int count;
    static int lastCount;
    static Queue<int[]> queue;
    // 위부터 시계방향으로 탐색
    static int[] dr = {0, 1, 0, -1}; 
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
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

        // 큐 생성후 초기위치인 0, 0을 삽입
        queue = new ArrayDeque<>();
        // 타임값 치즈나 공기와 구분을 위해 2를 넣어줌 / 나중에 2를 빼줬음
        time = 2;
        queue.offer(new int[] {0, 0});
        
        // 큐가 비지 않았으면 bfs 호출
        while (!queue.isEmpty()) {
            // 방문했던 기록 모두 초기화
            isVisited = new boolean[N][M];
            bfs();
            // 카운트가 0이 아니라면 최종카운트에 삽입
            if (count != 0) lastCount = count;
        }

        sb.append(time - 2).append("\n").append(lastCount);
        System.out.println(sb.toString());

        
    }

    static void bfs() {
        count = 0;
        // 최초 치즈 위치 값
        int[] first = new int[] {-1, -1};
        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = location[0] + dr[i];
                int nc = location[1] + dc[i];
                

                if (!mapCheck(nr, nc) || isVisited[nr][nc] == true) continue;

                
                if (map[nr][nc] == 1) {  // 치즈가 있는지
                    // 최초 치즈 위치
                    if (first[0] == -1) {
                        first[0] = nr;
                        first[1] = nc;
                    }
                    // 현재 타임값 넣기
                    map[nr][nc] = time;
                    count++;
                } else if (map[nr][nc] == 0 || map[nr][nc] < time) {  // 공기이거나 사라진 치즈인지
                    queue.offer(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                }
            }
        }

        // 더이상 찾을 치즈가 없는 경우 최초 치즈 위치를 큐에 넣고 시간을 증가시킴
        if (first[0] != -1) {
            queue.offer(first);
            time++;
        }
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    
}
