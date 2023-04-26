import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 데스나이트

public class Main {

    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static Node start, end;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        int result = bfs();
        System.out.println(result);
    }
    private static int bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(start.r, start.c));
        int count = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                if (cur.r == end.r && cur.c == end.c) {
                    return count;
                }
                if (visited[cur.r][cur.c]) continue;
                visited[cur.r][cur.c] = true;


                for (int d = 0; d < 6; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (!isInRange(nr, nc)) continue;
                    que.offer(new Node(nr, nc));
                }
            }

            count++;
        }

        return -1;
    }
    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    private static void init() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        map = new int[N][N];
        visited = new boolean[N][N];
    }
}