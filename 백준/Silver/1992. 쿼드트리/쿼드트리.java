import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        explore(0, 0, N);
        System.out.println(sb.toString());
    }

    // 분할 정복
    static void explore(int r, int c, int width) {
        if (width == 1 || isSameNumber(r, c, width)) {
            sb.append(map[r][c]);
            return;
        }

        width /= 2;
        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                explore(r + width * i, c + width * j, width);
            }
        }
        sb.append(")");
    }

    static boolean isSameNumber(int r, int c, int width) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (map[r][c] != map[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
