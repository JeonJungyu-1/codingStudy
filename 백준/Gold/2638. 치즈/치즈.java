import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static Queue<Node> que;
    static Queue<Node> rQue;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        que = new ArrayDeque<>();
        rQue = new ArrayDeque<>();
        que.add(new Node(0, 0));
        int time = 0;
        int count = 0;
        while (true) {
            boolean isSuccess = false;
            for (int i = 0; i < N; i++) {
                copyMap[i] = Arrays.copyOf(map[i], M);
            }
            bfs();
            
            
            count = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 3) {
                        map[i][j] = 0;
                    }
                    if (map[i][j] == 1) {
                        isSuccess = true;
                    } 
                }
            }
            que.add(new Node(0, 0));

            time++;
            if (!isSuccess) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time);
        System.out.println(sb.toString());
        

    }


    static void bfs() {
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (copyMap[node.r][node.c] == 0) {
                copyMap[node.r][node.c] = -1;
            }

          
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc)) continue;
                if (copyMap[nr][nc] == 1 || copyMap[nr][nc] == 2) {
                    copyMap[nr][nc]++;
                } else if (copyMap[nr][nc] == 0){
                    copyMap[nr][nc] = -1;
                    que.add(new Node(nr, nc));
                }
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