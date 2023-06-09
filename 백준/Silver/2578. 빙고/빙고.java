import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 빙고

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int[][] map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo += searchNumber(Integer.parseInt(st.nextToken()), map);
                if (bingo >= 3) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }





    }



    private static int searchNumber(int number, int[][] map) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == number) {
                    map[i][j] = -1;

                    //오른쪽 아래 대각선 체크
                    if (i == j) cnt += diagonalDownCheck(map);


                    //오른쪽 위 대각선 체크 
                    if (i + j == 4) cnt += diagonalUpCheck(map);

                    //가로 체크
                    cnt += rowCheck(i, map);

                    //세로 체크
                    cnt += columnCheck(j, map);

                    return cnt;
                }
            }
        }

        return cnt;

    }



    private static int rowCheck(int r, int[][] map) {
        for (int c = 0; c < 5; c++) {
            if (map[r][c] != -1) return 0;
        }

        return 1;
    }

    private static int columnCheck(int c, int[][] map) {
        for (int r = 0; r < 5; r++) {
            if (map[r][c] != -1) return 0;
        }

        return 1;
    }

    private static int diagonalDownCheck(int[][] map) {
        for (int r = 0; r < 5; r++) {
            if (map[r][r] != -1) return 0;
        }

        return 1;
    }

    private static int diagonalUpCheck(int[][] map) {
        for (int r = 0; r < 5; r++) {
            if (map[r][4 - r] != -1) return 0;
        }

        return 1;
    }
    


}