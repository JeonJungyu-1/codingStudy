import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 직사각형에서 탈출

public class Main {
    static int x, y, w, h;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
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
        x = Integer.parseInt(st.nextToken());        
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[10][3];

        int result = bfs();

        System.out.println(result);


    }
    private static int bfs() {
        int time = 0;
        Queue<Node> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[w][h];
        que.offer(new Node(x, y));
        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                if (cur.r == w || cur.r == 0 || cur.c == h || cur.c == 0) {
                    return time;
                }
                if (visited[cur.r][cur.c]) continue;
                visited[cur.r][cur.c] = true;
    
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    
    
                    que.offer(new Node(nr, nc));
                }
            }
            time++;
        }

        return time;
    }
    
}