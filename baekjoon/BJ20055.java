package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 컨베이어 벨트 위의 로봇
// 문제에 따라 차례대로 구현만 하면 됨

public class BJ20055 {
    static StringBuilder sb;
    static int N, K;
    static int[] block;
    static boolean[] hasRobot;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        int zero = 0;
        while (true) {
            if (zero >= K) break;

            // 전체 칸 회전
            rotateBlock();
            if (hasRobot[N - 1]) {
                hasRobot[N - 1] = false;
            }

            // 로봇 한칸씩 이동
            for (int i = N - 2; i >= 0; i--) {
                if (hasRobot[i] && block[i + 1] != 0 && !hasRobot[i + 1]) {
                    zero = moveRobot(zero, i, i + 1);
                }
                    
            }

            // 로봇 올리기
            zero = upRobot(zero);
            cnt++;
        }

    }

    private static int upRobot(int zero) {
        if (block[0] != 0 && !hasRobot[0]) {
            hasRobot[0] = true;
            block[0]--;
            if (block[0] == 0) {
                zero++;
            }
        }
        return zero;
    }


    private static int moveRobot(int zero, int currentRobot, int newRobot) {
        if (newRobot != N - 1) {
            hasRobot[newRobot] = true;
        }
        hasRobot[currentRobot] = false;
        block[newRobot]--;
        if (block[newRobot] == 0) {
            zero++;
        }
        return zero;
    }

    private static void rotateBlock() {
        int lastBlock = block[block.length - 1];
        boolean lastRobot = hasRobot[block.length - 1];
        for (int i = block.length - 2; i >= 0; i--) {
            block[i + 1] = block[i];
            hasRobot[i + 1] = hasRobot[i];
        }
        block[0] = lastBlock;
        hasRobot[0] = lastRobot;
        

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        block = new int[2 * N];
        hasRobot = new boolean[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
    }
}
