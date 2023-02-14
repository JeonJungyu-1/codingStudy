package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 영역 구하기
public class BJ2583 {
    static int N, M, K;
    static int[][] map;
    static List<Integer> list;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            Node startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Node endNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = startNode.r; j < endNode.r; j++) {
                for (int k = startNode.c; k < endNode.c; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int count = 0;
        //bfs
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         if (map[i][j] == 0) {
        //             bfs(i, j);
        //             count++;
        //         }
        //     }
        // }         
        
        //dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    num = 0;
                    dfs(i, j);
                    list.add(num);
                    count++;
                }
            }
        }      


                
        
        
        Collections.sort(list);
        sb.append(count).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i == list.size() - 1) break;
            sb.append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    }

    static void dfs(int r, int c) {
        if (map[r][c] == 1) return;

        map[r][c] = 1;
        num++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!mapCheck(nr, nc)) continue;
            dfs(nr, nc);
        }


    }

    static void bfs(int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c));
        map[r][c] = 1;
        int cnt = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapCheck(nr, nc) || map[nr][nc] != 0) continue;
                que.offer(new Node(nr, nc));
                map[nr][nc] = 1;
                cnt++;
            }

        }
        list.add(cnt);
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static class Node {
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        int r;
        int c;
    }
}
