import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕!
// 구현 문제

public class Main {
    static StringBuilder sb;
    static int R, C, T;
    static int[][] map;
    static Queue<Node> dustQue;
    static Node airNode;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int sum;
    static class Node {
        int r, c, dust;

        public Node(int r, int c, int dust) {
            this.r = r;
            this.c = c;
            this.dust = dust;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sum);
    }

    private static void solve() {
        int time = 0;
        while (true) {
            if (time == T) break;
            // 현재 미세먼지 큐에 저장
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) dustQue.offer(new Node(i, j, map[i][j] / 5));
                }
            }
            // 미세먼지 확산
            spreadDust();

            // 공기청정기 작동
            // airNode에 위쪽 좌표 들어있음
            operateAir();
            time++;
        }


        sum = 0;
        // 남은 미세먼지 합치기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }

    }

    private static void operateAir() {
        // 위쪽 공기청정기
        // 왼
        for (int i = airNode.r - 1; i >= 0; i--) {
            if (i == airNode.r - 1) {
                map[i][0] = 0;
            } else {
                map[i + 1][0] = map[i][0];
            }
        }
        // 위
        for (int i = 1; i < C; i++) {
            map[0][i - 1] = map[0][i];
        }
        // 오
        for (int i = 1; i <= airNode.r; i++) {
            map[i - 1][C - 1] = map[i][C - 1];
        }
        // 아
        for (int i = C - 1; i >= 1; i--) {
            if (i == 1) {
                map[airNode.r][i] = 0;
            } else {
                map[airNode.r][i] = map[airNode.r][i - 1];
            }
        }
        
        
        // 아래쪽 공기청정기
        // 왼
        for (int i = airNode.r + 2; i < R; i++) {
            if (i == airNode.r + 2) {
                map[i][0] = 0;
            } else {
                map[i - 1][0] = map[i][0];
            }
        }
        // 아
        for (int i = 1; i < C; i++) {
            map[R - 1][i - 1] = map[R - 1][i];
        }
        // 오
        for (int i = R - 1; i > airNode.r + 1; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        // 위
        for (int i = C - 1; i >= 1; i--) {
            if (i == 1) {
                map[airNode.r + 1][i] = 0;
            } else {
                map[airNode.r + 1][i] = map[airNode.r + 1][i - 1];
            }
        }

    }

    private static void spreadDust() {
        
        while (!dustQue.isEmpty()) {
            int size = dustQue.size();
            
            for (int i = 0; i < size; i++) {
                Node cur = dustQue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (!isInRange(nr, nc) || map[nr][nc] == -1) continue;

                    map[cur.r][cur.c] -= cur.dust;
                    map[nr][nc] += cur.dust;
                }
            }

            

        }
    }

  

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dustQue = new ArrayDeque<>();
        airNode = null;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airNode == null) airNode = new Node(i, j, 0);
                }
            }
        }


    }
}