import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] p, r;
    static int N, M;
    static int[][] map;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static PriorityQueue<Edge> pq;
    static HashSet<Edge> set;
    static int V;
    static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
        @Override
        public String toString() {
            return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + s;
            result = prime * result + e;
            result = prime * result + w;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (s != other.s)
                return false;
            if (e != other.e)
                return false;
            if (w != other.w)
                return false;
            return true;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        
    }

    private static void solve() {
        // 1. ff 섬찾기
        V = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    V++;
                    bfs(i, j, V);
                }
            }
        }

        // 2. 섬간 거리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 2; k++) {
                        searchIsland(i, j, k);
                    }
                }
            }
        }

        
        pq = new PriorityQueue<>(set);
        // while (!pq.isEmpty()) {
        //     System.out.println(pq.poll());
        // }
        int min = 0;
        // if (!pq.isEmpty()) {
            makeSet();
            int cnt = 0;
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if (union(e.s, e.e)) {
                    min += e.w;
                    cnt++;
                }
            }

            if (cnt != V - 1) {
                min = -1;
            }

        // } else {
        //     min = -1;
        // }

        System.out.println(min);

        // System.out.println(set);

        // for (int[] a: map) {
        //     System.out.println(Arrays.toString(a));
        // }
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        if (r[x] > r[y]) {
            p[y] = x;
            r[x] += r[y];
        } else {
            p[x] = y;
            r[y] += r[x];
        }
        return true;
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }

    private static void makeSet() {
        p = new int[V + 1];
        r = new int[V + 1];
        for (int i = 0; i < V; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }

    private static void searchIsland(int r, int c, int d) {
        int cnt = 0;
        switch (d) {
            case 0:
                for (int i = c + 1; i < M; i++) {
                    if (map[r][i] != 0) {
                        if (cnt != 1 && map[r][c] != map[r][i]) {
                            set.add(new Edge(map[r][c], map[r][i], cnt));
                        }
                        break;
                    } else {
                        cnt++;
                    }
                }
                
                break;

            case 1:
                for (int i = r + 1; i < N; i++) {
                    if (map[i][c] != 0) {
                        if (cnt != 1 && map[r][c] != map[i][c]) {
                            set.add(new Edge(map[r][c], map[i][c], cnt));
                        }
                        break;
                    } else {
                        cnt++;
                    }
                }
                
                break;
           
            
        
        }
    }



    private static void bfs(int r, int c, int num) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));
        map[r][c] = num;

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] != -1) continue;
                que.offer(new Node(nr, nc));
                map[nr][nc] = num;
            }

        }

    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    } 

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) map[i][j] = -1;
            }
        }

    }
}