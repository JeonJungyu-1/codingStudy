import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 특정 거리의 도시 찾기

public class Main {
    
    static StringBuilder sb;
    static int N, M, K, X;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
        }


        boolean[] visited = new boolean[N + 1];
        List<Integer> list = new ArrayList<>();
        bfs(visited, adj, list);


        Collections.sort(list);
        if (list.size() == 0) {
            sb.append(-1);
        } else {
            for (int number : list) {
                sb.append(number).append("\n");
            }
        }

        System.out.println(sb.toString());

    }


    private static void bfs(boolean[] visited, List<List<Integer>> adj, List<Integer> list) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(X);
        visited[X] = true;
        int cnt = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            cnt++;
            if (cnt > K) return;

            for (int i = 0; i < size; i++) {
                int cur = que.poll();


                for (int next: adj.get(cur)) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    if (cnt == K) list.add(next);
                    que.offer(next);
                }
            }


        }
    }


}