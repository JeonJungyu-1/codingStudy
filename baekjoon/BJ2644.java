package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 촌수계산 - dfs
public class BJ2644 {
    static int N, M;
    static int[][] graph;
    static boolean[] isVisited;
    static int from, to;
    static int result;
    static boolean isSuccess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        result = -1;


        explore(0, from);

        System.out.println(result);




        br.close();
    }

    //dfs
    static void explore(int cnt, int start) {
        // 촌수 찾는데 성공했으면 리턴
        if (isSuccess) return;
        if (start == to) {
            result = cnt;
            isSuccess = true;
            return;
        }

        // 그래프 탐색
        for (int i = 1; i <= N; i++) {
            // 방문하지 않고, 관계가 있는 친척일 때
            if (!isVisited[i] && graph[start][i] == 1) {
                isVisited[i] = true;
                explore(cnt + 1, i);
                isVisited[i] = false;
                if (isSuccess) return;
            }
        }
    }
}
