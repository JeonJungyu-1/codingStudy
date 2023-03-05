package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N-QUEEN - 백트래킹
// 퀸은 대각선 상하좌우 이동
// 1. 먼저 같은 행에는 한개의 퀸만 놓을 수 있음.
// 2. 첫행에 놓은 퀸 기준으로 dfs를 계속 돌려나감
// 3. 같은 열이나 대각선에 있는 퀸들은 가지치기(pruning) 해나감
public class BJ9663 {
    static StringBuilder sb;
    static int N;
    static int[] queen;
    static int count;
    static boolean[] columnCheck; // 열체크용 배열
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() {
        // 1
        // for (int i = 0; i < N; i++) {
        //     queen[0] = i;
        //     explore(0, i);
        // }

        // 2
        for (int i = 0; i < N; i++) {
            columnCheck = new boolean[N];
            columnCheck[i] = true;
            queen[0] = i;
            explore2(0, i);
        }


    }

    // 2. 상하는 배열로 따로 체크하고, 그 후 대각선 체크
    private static void explore2(int r, int c) {
        if (r == N - 1) {
            count++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (columnCheck[i] || !queenCheck(r + 1, i)) continue;
            queen[r + 1] = i;
            columnCheck[i] = true;
            explore(r + 1, i);
            columnCheck[i] = false;
        }
    }



    // 1. 상하, 대각선 체크 한번에 하기
    private static void explore(int r, int c) {
        if (r == N - 1) {
            count++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!queenCheck(r + 1, i)) continue;
            queen[r + 1] = i;
            explore(r + 1, i);
        }
    }

    // 이전 퀸들의 상하, 대각선에 현재 선택한 퀸이 위치해 있는지
    private static boolean queenCheck(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (queen[i] == c || Math.abs(queen[i] - c) == Math.abs(i - r)) return false;
        }


        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        queen = new int[N];


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
