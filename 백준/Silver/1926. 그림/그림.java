import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Node> queue;
    static int cnt;
    static int maxArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        maxArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || isVisited[i][j]) continue;
                queue = new ArrayDeque<>();
                queue.add(new Node(i, j));
                explore();
                cnt++;
            }
        }

        if (cnt >= 1 && maxArea == 0) {
            maxArea = 1;
        }

        sb.append(cnt).append("\n").append(maxArea);
        System.out.println(sb.toString());
    }   

    static void explore() {
        int area = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] == 0 || isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                area++;
                queue.add(new Node(nr, nc));
            }
        }
        maxArea = Math.max(maxArea, area);
    }
    
    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        
    }
}
