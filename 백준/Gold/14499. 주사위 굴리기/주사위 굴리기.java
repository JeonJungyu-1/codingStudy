import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 굴리기
// 구현

public class Main {
    
    static StringBuilder sb;
    static int[] dice;
    static int[][] map;
    static int N, M, r, c, K;
    static int[] command;
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        int nr, nc;
        for (int i = 0; i < command.length; i++) {
            int d = command[i];
            nr = r + dr[d];
            nc = c + dc[d];
            if (!isInRange(nr, nc)) {
                continue;
            }
            roll(d);
            if (map[nr][nc] == 0) {
                map[nr][nc] = dice[3];
            } else {
                dice[3] = map[nr][nc];
                map[nr][nc] = 0;
            }
            r = nr;
            c = nc;
            sb.append(dice[0]).append("\n");

        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void roll(int direction) {
        int temp = 0;
        switch (direction) {
            case 1:
                temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;
                break;
            case 3:
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[1];
                dice[1] = temp;
                break;
            case 4:
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[4];
                dice[4] = temp;
                break;
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[6];
        command = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }
    }
}