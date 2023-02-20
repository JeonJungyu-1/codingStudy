import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int white, blue;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(sb.toString());
    }
    private static void solve() {
        divide(0, 0, N);
    }
    private static void divide(int r, int c, int size) {
        int color = 0;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) {
                    color++;
                }
            }
        }

        if (color == size * size) {
            white++;
        } else if (color == 0) {
            blue++;
        } else {
            int half = size / 2;
            divide(r, c, half);
            divide(r, c + half, half);
            divide(r + half, c, half);
            divide(r + half, c + half, half);
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
}