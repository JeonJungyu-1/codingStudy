import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리의 부모 찾기

public class Main {
    static int N;

    static List<ArrayList<Integer>> adj;
    static int[] memo;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj.get(s).add(e);
            adj.get(e).add(s);
        }

        memo = new int[N + 1];
        

        bfs();

        for (int i = 2; i < N + 1; i++) {
            sb.append(memo[i]).append(" ");
        }

        System.out.println(sb.toString());



    }

    private static void bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);

        while (!que.isEmpty()) {
            int cur = que.poll();
            

            for (int next : adj.get(cur)) {
                if (memo[next] != 0) continue;
                que.offer(next);
                memo[next] = cur;
            }
        }
    }   

}