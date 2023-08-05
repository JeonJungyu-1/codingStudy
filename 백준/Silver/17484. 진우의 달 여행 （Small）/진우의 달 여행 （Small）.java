import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진우의 달 여행 (Small)

public class Main {
    
    static StringBuilder sb;
    static int[] dr = {1, 1, 1};
    static int[] dc = {-1, 0, 1};
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            dfs(0, i, map[0][i], -1, result);
        }

        System.out.println(result[0]);
        
    }
    
    
    private static void dfs(int cnt, int c, int sum, int prevD, int[] result) {
        if (sum > result[0]) return;
        
        if (cnt == N - 1) {            
            result[0] = Math.min(result[0], sum);
            return;
        }


        for (int i = 0; i < 3; i++) {
            if (i == prevD) continue;
            int nc = c + dc[i];
            if (nc < 0 || nc >= M) continue;
            dfs(cnt + 1, nc, sum + map[cnt + 1][nc], i, result);
        }
    }
}