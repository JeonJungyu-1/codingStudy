import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;
    static int[][] copyMap;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();

    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    private static void solve() {
        
        // R %= ((N  * 2) + (M * 2) - 4);
        // for (int i = 0; i < R; i++) {
            rotate();
        // }

    }
    private static void rotate() {
        int cnt = Math.min(N, M) / 2;
        for (int i = 0; i < cnt; i++) {
            
            int K = R % (((N - i * 2)  * 2) + ((M - i * 2) * 2) - 4);
            for (int k = 0; k < K; k++) {

            
            int nn = N - i - 1;
            int mm = M - i - 1;
            int temp = map[nn][mm];
            // 아래
            for (int j = mm - 1; j >= i; j--) {
                map[nn][j + 1] = map[nn][j];
            }
            
            //왼
            for (int j = nn - 1; j >= i; j--) {
                map[j+1][i] = map[j][i];
            }
            // 위
            for (int j = i + 1; j <= mm; j++) {
                map[i][j - 1] = map[i][j];
            }
   
   
            //오
            for (int j = i + 1; j <= nn; j++) {
                map[j - 1][mm] = map[j][mm];
            }
            map[nn - 1][mm] = temp;
        }
            
        }
        
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
