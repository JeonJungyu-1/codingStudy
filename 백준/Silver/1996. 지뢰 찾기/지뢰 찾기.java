import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 지뢰 찾기

public class Main {
    
    static StringBuilder sb;
    static int[][] map;
    static int[][] input;
    static int N;
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dc = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(input[i][j] != 0 ? "*" : map[i][j] >= 10 ? "M"  : map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


    private static void solve() throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] != 0) {
                    installMine(i, j, input[i][j]);
                }
            }
        }

        print();
    }

    private static void installMine(int r, int c, int n) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isInRange(nr, nc)) continue;
            map[nr][nc] += n;
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        input = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (ch[j] != '.') {
                    input[i][j] = ch[j] - '0';
                }
            }
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}