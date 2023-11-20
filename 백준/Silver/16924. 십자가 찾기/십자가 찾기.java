import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 십자가 찾기

public class Main {
    
    static StringBuilder sb;
    static int totalStar, N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int star;

    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        if (star != totalStar) {   
            System.out.println(-1);
            return;
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();

        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                checkStar(i, j);
               
            }
        }

        

        print();
    }

    private static void checkStar(int r, int c) {
        int min = Integer.MAX_VALUE;

        // 좌 우 상 하
        int count = 0;
        for (int j = c; j >= 0; j--) {
            if (map[r][j] == 1) {
                count++;
            } else {
                break;
            }
        }
        min = Math.min(min, count - 1);

        count = 0;
        for (int j = c; j < M; j++) {
            if (map[r][j] == 1) {
                count++;
            } else {
                break;
            }
        }
        min = Math.min(min, count - 1);


        count = 0;
        for (int i = r; i >= 0; i--) {
            if (map[i][c] == 1) {
                count++;
            } else {
                break;
            }
        }
        min = Math.min(min, count - 1);

        count = 0;
        for (int i = r; i < N; i++) {
            if (map[i][c] == 1) {
                count++;
            } else {
                break;
            }
        }
        min = Math.min(min, count - 1);


        if (min != 0) {
            for (int i = r - min; i <= r + min; i++) {
                if (!visited[i][c]) star++;
                visited[i][c] = true;
            }
            for (int j = c - min; j <= c + min; j++) {
                if (!visited[r][j]) star++;
                visited[r][j] = true;
            }
            sb.append(r + 1).append(" ").append(c + 1).append(" ").append(min).append("\n");
            cnt++;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] == '.' ? 0 : 1;
                if (map[i][j] == 1) totalStar++;
            }
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}