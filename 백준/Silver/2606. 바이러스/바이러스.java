import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] distance;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }
        
        distance = new int[N + 1];
        count = 0;
        // bfs();
        dfs(1);
        result();
        // System.out.println(count);
    }

    static void result() {
        int count = 0;
        for (int i = 2; i < N + 1; i++) {
            if (distance[i] == 2) count++;
        }
        System.out.println(count);
    }

    private static void dfs(int s) {
        distance[s] = 2;
        for (int e = 2; e < N + 1; e++) {
            if (distance[e] != 0) continue; // 방문
            if (map[s][e] == 1) {
                dfs(e);
            }
        }
    }



    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        distance[1] = 2; // 방문;
        while (!que.isEmpty()) {
            int s = que.poll();
            for (int e = 2; e < N + 1; e++) {
                if (distance[e] != 0) continue; // 방문
                if (map[s][e] == 1) {
                    que.add(e);
                    distance[e] = 2;
                }
            }
        }
    }


}
