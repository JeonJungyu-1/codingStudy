import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// NM과 K (1)

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    static Node[] nodeList;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        nodeList = new Node[N * M];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                nodeList[i * M + j] = new Node(i, j);
            }
        }

        explore(0, 0);
        

        System.out.println(max);


    }

    private static void explore(int cnt, int sum) {
        if (cnt == K) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < nodeList.length; i++) {
            int r = nodeList[i].r;
            int c = nodeList[i].c;
            if (!mapCheck(r, c)) continue;
            visited[r][c] = true;
            explore(cnt + 1, sum + map[r][c]);
            visited[r][c] = false;
            
        }
    }

    private static boolean mapCheck(int r, int c) {
        return !visited[r][c] && (r - 1 < 0 || !visited[r - 1][c]) && (r + 1 >= N || !visited[r + 1][c]) && (c - 1 < 0 || !visited[r][c - 1]) && (c + 1 >= M || !visited[r][c + 1]);
    }
}