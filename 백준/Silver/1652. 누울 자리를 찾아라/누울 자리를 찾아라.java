import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누울 자리를 찾아라

public class Main {
    
    static StringBuilder sb;
    static int[][] map;
    static int N;
    static int row, column;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        sb.append(row).append(" ").append(column);
        System.out.println(sb.toString());

    }

    private static void solve() throws IOException {
        init();

        // 가로
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        row++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                row++;
            }
        }

        // 세로
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 0) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        column++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                column++;
            }
        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] == '.' ? 0: 1;
            }
        }


    }
}