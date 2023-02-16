import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//치즈 - bfs
public class Main {
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

        queue = new ArrayDeque<>();
        time = 2;
        queue.offer(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            isVisited = new boolean[N][M];
            bfs();
            if (count != 0) lastCount = count;
        }

        sb.append(time - 2).append("\n").append(lastCount);
        System.out.println(sb.toString());

        
    }

    static void bfs() {
        count = 0;
        int[] first = new int[] {-1, -1};
        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = location[0] + dr[i];
                int nc = location[1] + dc[i];
                

                if (!mapCheck(nr, nc) || isVisited[nr][nc] == true) continue;
                if (map[nr][nc] == 1) {
                    if (first[0] == -1) {
                        first[0] = nr;
                        first[1] = nc;
                    }
                    map[nr][nc] = time;
                    count++;
                } else if (map[nr][nc] == 0 || map[nr][nc] < time) {
                    queue.offer(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                }
            }
        }
        if (first[0] != -1) {
            queue.offer(first);
            time++;
        }
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    
}
