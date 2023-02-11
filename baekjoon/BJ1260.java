package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// DFS와 BFS - DFS는 인접행렬을 사용했고, BFS는 인접리스트를 사용해봄
public class BJ1260 {
    static int N, M, start;
    static List<ArrayList<Integer>> list;
    static int[][] visit;
    static boolean[] isVisited;
    static Queue<Integer> queue;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
        visit = new int[N + 1][N + 1];

        //인접행렬 - dfs
        List<Integer> currentList;
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            //인접 행렬 생성
            visit[first][second] = 1;
            visit[second][first] = 1;


            //인접 리스트 생성
            currentList = list.get(first);
            currentList.add(second);
            Collections.sort(currentList);
            currentList = list.get(second);
            currentList.add(first);
            Collections.sort(currentList);
        }
        isVisited[start] = true;
        sb.append(start).append(" ");
        dfs(0, start);
        sb.append("\n");



        Arrays.fill(isVisited, false);
        //인접리스트 - bfs
       
        
        // for (int i = 0; i < M; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     int first = Integer.parseInt(st.nextToken());
        //     int second = Integer.parseInt(st.nextToken());
        //     currentList = list.get(first);
        //     currentList.add(second);
        //     Collections.sort(currentList);
            
        //     currentList = list.get(second);
        //     currentList.add(first);
        //     Collections.sort(currentList);
        // }
        queue = new ArrayDeque<>();
        queue.add(start);
        bfs();
        
        System.out.println(sb.toString());

    }

    // dfs는 인접행렬 사용해보기 
    static void dfs(int cnt, int from) {
        if (cnt == N) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isVisited[i] == false && visit[from][i] == 1) {
                isVisited[i] = true;
                sb.append(i).append(" ");
                dfs(cnt + 1, i);
            }
        }
    }


    // bfs는 인접리스트 사용해보기
    static void bfs() {
        while (!queue.isEmpty()) {
            int from = queue.poll();
            isVisited[from] = true;
            sb.append(from).append(" ");
            List<Integer> fromList = list.get(from);

            for (int i = 0; i < fromList.size(); i++) {
                int num = fromList.get(i);
                if (isVisited[num] == false) {
                    queue.add(num);
                    isVisited[num] = true;
                }
            }

        }
    }
}
