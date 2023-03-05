package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
// 1. nCn/2로 조합을 구해서 스타트팀과 링크팀을 나누기
// 2. 나눈 팀을 가지고 다시 n/2C2을 통해 능력치 더해주기

public class BJ14889 {
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static boolean[] isVisited;
    static int min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        combination(0, 0);

    }

    private static void combination(int cnt, int start) {
        if (cnt == N/2) {
            calStatDiff();
        }

        for (int i = start; i < N; i++) {
            isVisited[i] = true;
            combination(cnt + 1, i + 1);
            isVisited[i] = false;
        }
    
    }

    private static void calStatDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i != j) {
                    if (isVisited[i] && isVisited[j]) {
                        start += map[i][j];
                        start += map[j][i];
                    } else if (!isVisited[i] && !isVisited[j]) {
                        link += map[i][j];
                        link += map[j][i];
                    }
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
        

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
