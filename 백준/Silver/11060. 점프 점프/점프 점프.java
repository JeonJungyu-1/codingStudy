import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프 점프
// bfs

public class Main {
    
    static StringBuilder sb;
    static int n;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        boolean[] visited = new boolean[n];
        int result = -1;
        int cnt = -1;
        while (!que.isEmpty()) {
            cnt++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int x = que.poll();
                if (visited[x]) continue;
                visited[x] = true;

                if (x == n - 1) {
                    que.clear();
                    result = cnt;
                    break;
                }
                for (int j = 1; j <= numbers[x]; j++) {
                    if (x + j >= n) break;
                    que.offer(x + j);
                }
            }

        }

        return result;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }



    }
}