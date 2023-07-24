import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int max;

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
        map = new int[N][M];
        visited = new boolean[N][M];

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] == 'W' ? 1 : 0;
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                bfs(i, j);
            }
        }


        System.out.println(max);
    }

    public static void bfs(int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));
        int cnt = -2;
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        while (!que.isEmpty()) {

            int size = que.size();



            for (int i = 0; i < size; i++) {
                Node cur = que.poll();

                if (visited[cur.r][cur.c]) continue;
                visited[cur.r][cur.c] = true;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isInRange(nr, nc) || map[nr][nc] == 1) continue;
                    que.offer(new Node(nr, nc));

                }

            }
            
            cnt++;
        }
        
        max = Math.max(max, cnt);

        

    }

    public static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}