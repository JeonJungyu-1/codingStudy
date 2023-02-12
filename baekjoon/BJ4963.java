package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수 - bfs
public class BJ4963 {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Node> queue;
    static int[] dr = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            map = new int[N][M];
            isVisited = new boolean[N][M];
            queue = new ArrayDeque<>();
            island = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 || isVisited[i][j]) continue;
                    queue.add(new Node(i, j));
                    explore();
                    island++;
                }
            }

            sb.append(island).append("\n");

        }        


        System.out.println(sb.toString());



        br.close();
    }

    static void explore() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            

            for (int i = 0; i < 8; i++) {
                int nr = node.r + dr[i]; 
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || isVisited[nr][nc] || map[nr][nc] == 0) continue;
                queue.add(new Node(nr, nc));
                isVisited[nr][nc] = true;
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
