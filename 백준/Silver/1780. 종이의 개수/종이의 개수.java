import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        counts = new int[3];

        explore(0, 0, N);

        for (int count: counts) {
            sb.append(count).append("\n");
        }

        System.out.println(sb);


    }

    static void explore(int r, int c, int width) {
        if (width == 1 || isSameNumber(r, c, width)) {
            int firstNumber = map[r][c];
            if (firstNumber == -1) {
                counts[0]++;
            } else if (firstNumber == 0) {
                counts[1]++;
            } else {
                counts[2]++;
            }
            return;
        }

        width /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                explore(r + width * i, c + width * j, width);
            }
        }

    }

    static boolean isSameNumber(int r, int c, int width) {
        int firstNumber = map[r][c];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (map[r + i][c + j] != firstNumber) {
                    return false;
                }
            }
        }

        return true;
    }
}
