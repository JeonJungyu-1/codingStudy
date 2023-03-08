import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;
    static int passCount;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(passCount);
    }

    private static void solve() {
        passCount = 0;
        // 1. 낮 -> 높
        // 2. 높 -> 낮
        // 3. 연속되었는지
        // 가로
        isVisited = new boolean[N][N];
        a:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] + 1 == map[i][j + 1]) { //낮 -> 높
                    if (isVisited[i][j]) continue a;
                    isVisited[i][j] = true;
                    for (int k = 1; k < L; k++) {
                        if (j - k < 0 || map[i][j] != map[i][j - k]) continue a;
                        if (isVisited[i][j - k]) continue a;
                        isVisited[i][j - k] = true;
                        
                    }
                } else if (map[i][j] == map[i][j + 1] + 1) { //높 -> 낮
                    if (isVisited[i][j + 1]) continue a;
                    isVisited[i][j + 1] = true;
                    for (int k = 1; k < L; k++) {
                        if (j + 1 + k >= N || map[i][j + 1] != map[i][j + 1 + k]) continue a;
                        if (isVisited[i][j + 1 + k]) continue a;
                        isVisited[i][j + 1 + k] = true;
                    }
                } else if (Math.abs(map[i][j] - map[i][j + 1]) >= 2) { // 1이상의 차이
                    continue a;
                }
                
            }
            passCount++;
        }


        // 세로
        isVisited = new boolean[N][N];
        a:
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] + 1 == map[i + 1][j]) { //낮 -> 높
                    if (isVisited[i][j]) continue a;
                    isVisited[i][j] = true;
                    for (int k = 1; k < L; k++) {
                        if (i - k < 0 || map[i][j] != map[i - k][j]) continue a;
                        if (isVisited[i - k][j]) continue a;
                        isVisited[i - k][j] = true;
                    }
                } else if (map[i][j] == map[i + 1][j] + 1) { //높 -> 낮
                    if (isVisited[i + 1][j]) continue a;
                    isVisited[i + 1][j] = true;
                    for (int k = 1; k < L; k++) {
                        if (i + 1 + k >= N || map[i + 1][j] != map[i + 1 + k][j]) continue a;
                        if (isVisited[i + 1 + k][j]) continue a;
                        isVisited[i + 1 + k][j] = true;
                    }
                } else if (Math.abs(map[i][j] - map[i + 1][j]) >= 2) { // 1이상의 차이
                    continue a;
                }
            }
            passCount++;

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}