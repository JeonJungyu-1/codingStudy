import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 연구소 2
    // BFS, 조합
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<Node> nodeList;
    static Node[] selectNodes;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int totalZero;

    static int minTime;

    static class Node {
        int r, c, t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime == Integer.MIN_VALUE ?  0 : minTime);
    }

    private static void solve() {
        combination(0, 0);
    }

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = start; i < nodeList.size(); i++) {
            selectNodes[cnt] = nodeList.get(i);
            combination(cnt + 1, i + 1);
        }
    }

    

    private static void bfs() {
        int maxTime = Integer.MIN_VALUE;
        Queue<Node> que = new ArrayDeque<>();
        visited = new boolean[N][N];
        for (Node cur: selectNodes) {
            que.offer(new Node(cur.r, cur.c, 0));
            visited[cur.r][cur.c] = true;
        }


        int zeroCnt = M;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || visited[nr][nc] || map[nr][nc] == -1) continue;
                que.offer(new Node(nr, nc, cur.t + 1));
                map[nr][nc] = cur.t + 1;
                visited[nr][nc] = true;
                maxTime = Math.max(maxTime, map[nr][nc]);
                zeroCnt++;
            }
        }

        if (zeroCnt == totalZero) {
            minTime = Math.min(minTime, maxTime);
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    nodeList.add(new Node(i, j, 0));
                    map[i][j] = 0;
                    totalZero++;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                } else {
                    totalZero++;
                }
            }
        }

        selectNodes = new Node[M];
        minTime = Integer.MAX_VALUE;
    }
}