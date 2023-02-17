import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 배열 돌리기 4
public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] copyMap;
    // static List<Rotate> list;
    static boolean[] isVisited;
    static Rotate[] numbers;
    static Rotate[] selected;
    static int minSum;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();

    }
    private static void print() {
        System.out.println(minSum);
    }
    private static void solve() {
        isVisited = new boolean[K];
        perm(0);
    }
    private static void perm(int cnt) {
        if (cnt == K) {
            mapCopy();
            for (int i = 0; i < selected.length; i++) {
                rotate(selected[i]);
            }
            calSum();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            selected[cnt] = numbers[i];
            perm(cnt + 1);
            isVisited[i] = false;
        }

    }
    private static void calSum() {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copyMap[i][j];
            }
            minSum = Math.min(minSum, sum);
        }
    }

    private static void mapCopy() {
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], M);
        }
    }

    private static void rotate(Rotate ro) {
        
        for (int i = 0; i < ro.s; i++) {
            int addR = ro.r - ro.s - 1;
            int addC = ro.c - ro.s - 1;
            int nn = ro.r + ro.s - i - 1;
            int mm = ro.c + ro.s - i - 1;
            int temp = copyMap[nn][mm];
            //오
            for (int j = 2 * ro.s - i; j > i; j--) {
                copyMap[addR + j][mm] = copyMap[addR + j - 1][mm];
            }
            // 위
            for (int j = 2 * ro.s - i; j > i; j--) {
                copyMap[i + addR][addC + j] = copyMap[i + addR][addC + j - 1];
            }
            //왼
            for (int j = i + 1; j <= ro.s * 2 - i; j++) {
                copyMap[j - 1 + addR][i + addC] = copyMap[j + addR][i + addC];
            }

            // 아래
            for (int j = i + 1; j <= ro.s * 2 - i; j++) {
                copyMap[nn][j - 1 + addC] = copyMap[nn][j + addC];
            }

   
            
            copyMap[nn][mm - 1] = temp;

            
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        selected = new Rotate[K];
        numbers = new Rotate[K];
        minSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    // list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            // list.add(new Rotate(r, c, s));
            numbers[i] = new Rotate(r, c, s);
        }

    }

    static class Rotate {
        int r;
        int c;
        int s;
        public Rotate(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
        
    }
}