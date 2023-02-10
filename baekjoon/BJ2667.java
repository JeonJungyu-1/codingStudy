package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

// 단지번호 붙이기 - bfs/dfs
public class BJ2667 {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<int[]> queue;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static StringBuilder sb;
    static int count;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        count = 0;
        
        map = new int[N][N];
        isVisited = new boolean[N][N];
        

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            char[] ch = st.toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        queue = new ArrayDeque<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && isVisited[i][j] == false) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                    bfs();
                    count++;
                }
            }
        }

        Collections.sort(list);
        sb.append(count).append("\n");
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb.toString());

    }   

    //bfs
    static void bfs() {
        int num = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                if (mapCheck(nr, nc) && map[nr][nc] == 1 && isVisited[nr][nc] == false) {
                    queue.add(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                    num++;
                }
            }
        }

        list.add(num);
        
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
