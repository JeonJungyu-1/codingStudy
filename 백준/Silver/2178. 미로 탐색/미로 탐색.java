import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static Queue<Node> queue;
    static int min;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }
        bfs();
        System.out.println(distance[N - 1][M - 1]);
    }

    static void bfs() {
        queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] == 0 || distance[nr][nc] != 0) continue;
                distance[nr][nc] = distance[node.r][node.c] + 1;
                if (nr == N - 1 && nc == M - 1) return;
                queue.add(new Node(nr, nc));
            }

        }
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
