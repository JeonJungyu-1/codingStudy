import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 2

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int[] result) {
        sb.append(result[0]).append("\n").append(result[1]);
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        int[] result = bfs();
        print(result);
    }

    private static int[] bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(N);
        int time = 0;
        int count = 0;
        boolean isEnd = false;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                visited[cur] = true;
                if (cur < 0 || cur > 100000) continue;
                if (cur == K) {
                    count++;
                    isEnd = true;
                }

                if (cur * 2 > 0 && cur * 2 < 100001 && !visited[cur * 2]) {
                    que.offer(cur * 2);
                }

                if (cur + 1 <= K && !visited[cur + 1]) {
                    que.offer(cur + 1);
                }

                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    que.offer(cur - 1);
                }
            }
            if (isEnd) break;
            time++;
        }

        return new int[] {time, count};
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

      



    }
}