import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<Node> que;
    static Queue<Node> waterque;
    static Node start, end;
    static boolean[][] isVisited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int time;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        // System.out.println(time);
        StringBuilder sb = new StringBuilder();
        if (time == -1) {
            sb.append("KAKTUS");
        } else {
            sb.append(time);
        }

        System.out.println(sb.toString());

    }

    private static void solve() {
        explore();
    }

    private static void explore() {
        que.offer(start);
        isVisited[start.r][start.c] = true;
        que.addAll(waterque);
        boolean isSuccess = false;
        while (!que.isEmpty()) {

            Node node = que.poll();

            // for (int[] a: map) {
            //     System.out.println(Arrays.toString(a));
            // }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] == -2 || isVisited[nr][nc]) continue;
                if (map[nr][nc] == 2 && map[node.r][node.c] != 1) continue;
                if (map[nr][nc] == 2 && map[node.r][node.c] == 1) {
                    que.clear();
                    time = node.time;
                    isSuccess = true;
                    break;
                }
                
                
                if (map[node.r][node.c] == 1 && map[nr][nc] == 0) {
                    map[nr][nc] = map[node.r][node.c];
                    que.offer(new Node(nr, nc, node.time + 1));                    
                } 
                if (map[node.r][node.c] == -1) {
                    isVisited[nr][nc] = true;
                    map[nr][nc] = map[node.r][node.c];

                    que.offer(new Node(nr, nc));
                }
                

            }

        }

        if (!isSuccess) {
            time = -1;
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
        isVisited = new boolean[N][M];
        que = new ArrayDeque<>();
        waterque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == 'D') {
                    end = new Node(i, j);
                    map[i][j] = 2;
                } else if (ch[j] == 'S') {
                    start = new Node(i, j, 1);
                    map[i][j] = 1;
                } else if (ch[j] == '*') {
                    waterque.offer(new Node(i, j));
                    map[i][j] = -1;
                } else if (ch[j] == 'X') {
                    map[i][j] = -2;
                }
                else {
                    map[i][j] = 0;
                }
            }
        }

    }

    static class Node {
        int r;
        int c;
        int time;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        
        
    }
}