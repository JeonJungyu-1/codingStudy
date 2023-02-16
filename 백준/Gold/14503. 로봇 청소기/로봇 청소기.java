import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sr, sc, d;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        explore(0, sr, sc);
        System.out.println(count);

    }

    static void explore(int cnt, int r, int c) {
        // 1. 현재 칸 청소
        if (map[r][c] == 0) {
            map[r][c] = -1;
            count++;
        }

        // 3. 청소할 칸이 있는 경우
        if (cleaningCheck(r, c)) {
            for (int i = 0; i < 4; i++) {
                d--;
                d = d == -1 ? 3: d;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!mapCheck(nr, nc)) continue;
                if (map[nr][nc] == 0) { 
                    explore(cnt + 1, nr, nc);
                    break;
                }
            }

        } else { // 2. 청소할 칸이 없는 경우
            int nd = d % 2 == 0 ? 2 - d : 4 - d;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if (!mapCheck(nr, nc) || backWallCheck(nr, nc)) {
                return;
            } else {
                explore(cnt + 1, nr, nc);
            }
        }
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >=0 && c < M;
    }

    // 현재칸 기준 사방 청소 확인
    static boolean cleaningCheck(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!mapCheck(nr, nc)) continue;
            if (map[nr][nc] == 0) return true;
        }
         return false;
    }

    // 뒤쪽 벽 체크
    static boolean backWallCheck(int r, int c) {
        if (map[r][c] == 1) return true;
        return false;
    }
}
