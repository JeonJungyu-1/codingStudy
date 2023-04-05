import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, X;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
    
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 가로
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                if (rowCheck(i)) {
                    cnt++;
                }
            }

            visited = new boolean[N][N];
            // 세로
            for (int i = 0; i < N; i++) {
                if (columnCheck(i)) {
                    cnt++;
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());



    }
    private static boolean rowCheck(int r) {
        for (int c = 0; c < N - 1; c++) {
            if (Math.abs(map[r][c] - map[r][c + 1]) >= 2) {
                return false;
            } else if (map[r][c] + 1 == map[r][c + 1]) {
                for (int i = 0; i < X; i++) {
                    if (c - i < 0 || visited[r][c - i]) return false;
                    visited[r][c - i] = true;
                }
            } else if (map[r][c] == map[r][c + 1] + 1) {
                for (int i = 0; i < X; i++) {
                    if (c + i + 1 >= N || visited[r][c + 1 + i]) return false;
                    visited[r][c + 1 + i] = true;
                }
            }
        }
        return true;
    }

    private static boolean columnCheck(int c) {
        for (int r = 0; r < N - 1; r++) {
            if (Math.abs(map[r][c] - map[r + 1][c]) >= 2) {
                return false;
            } else if (map[r][c] + 1 == map[r + 1][c]) {
                for (int i = 0; i < X; i++) {
                    if (r - i < 0 || visited[r - i][c]) return false;
                    visited[r - i][c] = true;
                }
            } else if (map[r][c] == map[r + 1][c] + 1) {
                for (int i = 0; i < X; i++) {
                    if (r + i + 1 >= N || visited[r + 1 + i][c]) return false;
                    visited[r + 1 + i][c] = true;
                }
            }
        }
        return true;
    }
}