import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나이트 투어

public class Main {
    
    static StringBuilder sb;
    static int[][] map;
    static int[] dr = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dc = {2, 1, 2, 1, -2, -1, -2, -1};
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new int[7][7];
        String str = "Invalid";
        char[] first = br.readLine().toCharArray();
        char[] ch = null;
        char[] before = first;
        map[first[0] - 64][first[1] - '0'] = 1;
        for (int i = 2; i < 37; i++) {
            ch = br.readLine().toCharArray();
            int r = ch[0] - 64;
            int c = ch[1] - '0';
            if (map[r][c] == 0) {
                map[r][c] = i;
            } else {
                System.out.println("Invalid");
                return;
            }

            int rDiff = Math.abs(before[0] - 64 - r);
            int cDiff = Math.abs(before[1] - '0' - c);
            if ((rDiff != 1 || cDiff != 2) && (rDiff != 2 || cDiff != 1)) {
                System.out.println("Invalid");
                return;
            }

            before = ch;
        }

        // 시작점으로 돌아갈 수 있는지
        for (int i = 0; i < 8; i++) {
            int nr = ch[0] - 64 + dr[i];
            int nc = ch[1] - '0' + dc[i];
            if (first[0] - 64 == nr && first[1] - '0' == nc) {
                str = "Valid";
            }
        }


        System.out.println(str);

    }
}