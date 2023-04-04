import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기

public class Main {
    static int N;
    static int minDistance;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 섬 나눠주기 (2부터 시작)
        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        // 거리 계산
        minDistance = Integer.MAX_VALUE;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                initVisited();
                calculateDistance(i, j, map[i][j]);
            }
        }
        System.out.println(minDistance);

    }
    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
    private static void calculateDistance(int r, int c, int num) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c, 0));
        visited[r][c] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || visited[nr][nc]) continue;
                if (map[nr][nc] != num && map[nr][nc] != 0) {
                    minDistance = Math.min(minDistance, cur.d);
                    return;
                }
                if (map[nr][nc] == num) continue;
                que.offer(new Node(nr, nc, cur.d + 1));
                visited[nr][nc] = true;
            }
        }
    }

    private static void bfs(int r, int c, int num) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c, 0));
        map[r][c] = num;

        while (!que.isEmpty()) {
            Node cur = que.poll();


            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];


                if (!isInRange(nr, nc) || map[nr][nc] != 1) continue;
                que.offer(new Node(nr, nc, 0));
                map[nr][nc] = num;
            }

            
        }
    }
    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}