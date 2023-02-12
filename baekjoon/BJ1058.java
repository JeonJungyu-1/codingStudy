package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 친구 - 2가지 방법으로 풀음(dfs, 플로이드 워셜)
public class BJ1058 {

    static int N;
    static int[][] map;
    static int[][] floyd;
    static boolean[] isVisited;
    static int friend;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        floyd = new int[N][N];
        max = -1;

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] == 'Y' ? 1 : 0;
                floyd[i][j] = map[i][j] == 1 ? 1 : i == j ? 0 : Integer.MAX_VALUE/1000;
            }
        }

        // 1. 모든 사람 차례대로 탐색 - 성공
        // for (int i = 0; i < N; i++) {
        //     friend = 0;
        //     isVisited = new boolean[N];
        //     isVisited[i] = true;
        //     explore(0, i);
        //     max = Math.max(max, friend);
        // }


        // 2. 플로이드 워셜
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || k == i) continue;
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (floyd[i][j] > 0 && floyd[i][j] <= 2) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        
        System.out.println(max);

        br.close();
    }

    // 1. dfs - 성공
    static void explore(int cnt, int from) {
        // 2친구까지만 구하기
        if (cnt == 2) {
            return;
        }


        for (int i = 0; i < N; i++) {
            if (map[from][i] == 0 || (cnt != 0 && isVisited[i])) continue;
            if (cnt != 0 || !isVisited[i]) {
                friend++;
            }
            isVisited[i] = true;
            explore(cnt + 1, i);
        }
    }
}
