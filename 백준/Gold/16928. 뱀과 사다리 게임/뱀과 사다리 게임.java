import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임

public class Main {
    static int N, M;
    static Map<Integer, Integer> move;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        init();
        int cnt = bfs();
        System.out.println(cnt);
    }



    private static int bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        int cnt = 0;

        while (!que.isEmpty()) {
            int size = que.size();


            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                if (cur == 100) {
                    return cnt;
                }
                if (cur > 100 || cur < 1 || visited[cur]) continue;
                visited[cur] = true;
    
                for (int j = 1; j <= 6; j++) {
                    int next = cur + j;

                    if (move.containsKey(next)) {
                        next = move.get(next);
                    }

                    que.offer(next);
                }

            }
            cnt++;

        }

        return cnt;
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        move = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            move.put(s, e);
        }
        visited = new boolean[101];
    }
}