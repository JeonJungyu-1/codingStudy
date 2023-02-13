package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 알고리즘 수업 - 깊이 우선 탐색 3
public class BJ24481 {
    static int N, M, start;
    static int[][] map;
    static int[] isVisited;
    static StringBuilder sb;
    static int count;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        //인접행렬 - 메모리 초과
        // map = new int[N + 1][N + 1];
        // for (int i = 0; i < M; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     int s = Integer.parseInt(st.nextToken());
        //     int e = Integer.parseInt(st.nextToken());
        //     map[s][e] = 1;
        //     map[e][s] = 1;
        // }

        //인접리스트 사용하기
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }
        
        isVisited = new int[N + 1];
        Arrays.fill(isVisited, -1);
        dfs(0, start);
        
        

        for (int i = 1; i <= N; i++) {
            sb.append(isVisited[i]).append("\n");
        }
        
        System.out.println(sb.toString());


        br.close();
    }


    // static void dfs(int cnt, int from) {
    //     isVisited[from] = cnt;

    //     for (int i = 1; i <= N; i++) {
    //         if (isVisited[i] != -1 || map[from][i] == 0) continue;
    //         dfs(cnt + 1, i);
            
    //     }
    // }

    static void dfs(int cnt, int from) {
        isVisited[from] = cnt;

        Collections.sort(list.get(from));
        for (int i = 0; i < list.get(from).size(); i++) {
            int newValue = list.get(from).get(i);
            if (isVisited[newValue] != -1) continue;
            dfs(cnt + 1, newValue);
        }
    }
}
