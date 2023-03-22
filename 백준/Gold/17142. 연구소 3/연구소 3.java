import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소 3
//bfs, 조합

public class Main {
    static int N, M;
    static int minTime;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static List<Node> nodeList;
    static Node[] selectedNode;
    static int totalZero;
    static class Node {
        int r, c, t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void solve() {
        if (totalZero != 0) {
            combination(0, 0);
        } else {
            minTime = 0;
        }
    }

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            int result = bfs();
            minTime = Math.min(result, minTime);
            return;
        }

        for (int i = start; i < nodeList.size(); i++) {
            selectedNode[cnt] = nodeList.get(i);
            combination(cnt + 1, i + 1);
        }
    }

    private static int bfs() {
        Queue<Node> que = new ArrayDeque<>();
        visited = new boolean[N][N];
        for (Node next : selectedNode) {
            que.offer(new Node(next.r, next.c, 0));
            visited[next.r][next.c] = true;
        }
        int zeroCnt = 0;

        while(!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!isInRange(nr, nc) || visited[nr][nc] || map[nr][nc] == -1) continue;
                if (map[nr][nc] == 0) {
                    zeroCnt++;
                }

                if (zeroCnt == totalZero) {
                    return cur.t + 1;
                }
                visited[nr][nc] = true;
                que.offer(new Node(nr, nc, cur.t + 1));

            }

        }

        return Integer.MAX_VALUE;

    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    nodeList.add(new Node(i, j, 0));
                    map[i][j] = 2;
                } else if (num == 1) {
                    map[i][j] = -1;
                } else {
                    totalZero++;
                }
            }
        }

        minTime = Integer.MAX_VALUE;
        selectedNode = new Node[M];




    }
}