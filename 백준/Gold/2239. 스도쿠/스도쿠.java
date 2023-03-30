import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 스도쿠
// 백트래킹

public class Main {
    static int[][] map;
    static boolean isSuccess;
    static List<Node> zeroList;
    static StringBuilder sb;

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    private static void solve() {
        dfs(0);
        System.out.println(sb.toString());
    }


    private static void dfs(int cnt) {

        if (cnt == zeroList.size()) {
            for (int[] m : map) {
                for (int num : m) {
                    sb.append(num);
                }
                sb.append("\n");
            }
            
    
            isSuccess = true;
            return;
        }

        Node cur = zeroList.get(cnt);
        for (int i = 1; i <= 9; i++) {
            if (!squareCheck(cur.r, cur.c, i) || !rowCheck(cur.r, i) || !columnCheck(cur.c, i)) continue;
            map[cur.r][cur.c] = i;
            if(isSuccess) return;
            dfs(cnt + 1);
            map[cur.r][cur.c] = 0;
        }

    }
    private static boolean squareCheck(int r, int c, int num) {
        r /= 3;
        c /= 3;

        r *= 3;
        c *= 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }

    private static boolean rowCheck(int r, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num) return false;
        }
        return true;
    }

    private static boolean columnCheck(int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == num) return false;
        }
        return true;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        zeroList = new ArrayList<>();
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                map[i][j] = ch[j] - '0';
                if (map[i][j] == 0) zeroList.add(new Node(i, j));
            }
        }

        
    }
}