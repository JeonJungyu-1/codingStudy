import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 달팽이2

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static boolean[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int cnt;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() throws IOException {
        init();
        int d = 0;
        int r = 1;
        int c = 1;
        while (true) {

            

            while (true) {
                if (map[r][c]) break;
                map[r][c] = true;


                r += dr[d];
                c += dc[d];
            }

            r -= dr[d];
            c -= dc[d];

            
            d = (d + 1) % 4;
            r += dr[d];
            c += dc[d];
            
            if (map[r][c]) break;
            cnt++;

        }


        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 2][M + 2];

        for (int i = 0; i < N + 2; i++) {
            map[i][0] = true;
            map[i][M + 1] = true;
        }


        for (int i = 0; i < M + 2; i++) {
            map[0][i] = true;
            map[N + 1][i] = true;
        }



    }
}