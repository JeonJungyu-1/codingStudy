import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb;
    static int N, M, T;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] == -1 ? "." : "O");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        int time = 0;

        time++;
        while (true) {
            if (time >= T) break;


            // 설치
            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == -1) map[i][j] = time;
                }
            }
            if (time >= T) break;
            
            // 폭발
            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == (time - 3)) {
                        bomb(i, j, time - 3);
                    }
                }
            }
        }

        print();
    }

    private static void bomb(int r, int c, int t) {
        map[r][c] = -1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc)) continue;
            if (map[nr][nc] != t) map[nr][nc] = -1;
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] != 'O') {
                    map[i][j] = -1;
                }
            }
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}