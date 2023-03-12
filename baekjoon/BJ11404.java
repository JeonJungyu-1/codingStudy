package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드
// 플로이드 워셜 알고리즘

public class BJ11404 {
    static StringBuilder sb;
    static int V, E;
    static int[][] adj;
    static int[][] distance;
    static final int INF = Integer.MAX_VALUE/100;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                sb.append(distance[i][j] == INF ? 0 : distance[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void solve() {
        // 최단거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else if (adj[i][j] != 0) {
                    distance[i][j] = adj[i][j];
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        // 플로이드 워셜
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adj = new int[V + 1][V + 1];
        distance = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (adj[s][e] == 0 || (adj[s][e] != 0 && adj[s][e] > w)) {
                adj[s][e] = w;
            }
        }

    }
}
