import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
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
        int cnt = Math.min(N, M) / 2;

        for (int k = 0; k < K; k++) {
            for (int i = 0; i < cnt; i++) {
                int nn = N - i - 1;
                int mm = M - i - 1;
                
    
                // 아래
                for (int j = mm - 1; j >= i; j--) {
                    copyMap[nn][j + 1] = map[nn][j];
                }
                
                // 위
                for (int j = i + 1; j <= mm; j++) {
                    copyMap[i][j - 1] = map[i][j];
                }
    
                //왼
                for (int j = nn - 1; j >= i; j--) {
                    copyMap[j+1][i] = map[j][i];
                }
    
                //오
                for (int j = i + 1; j <= nn; j++) {
                    copyMap[j - 1][mm] = map[j][mm];
                }
    
                
            }
            for (int j = 0; j < N; j++) {
                map[j] = Arrays.copyOf(copyMap[j], M);
            }

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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
