import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프 점프
// dfs

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] stones;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        stones = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());

        dfs(start - 1);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) cnt++;
        }

        System.out.println(cnt);


    }

    // private static void bfs(int start) {
    //     Queue<Integer> que = new ArrayDeque<>();
    //     que.offer(start);

    //     while (!que.isEmpty()) {
    //         int cur = que.poll();
    //         if (visited[cur]) continue;
    //         visited[cur] = true;

    //         for (int i = 1; i <= stones[cur]; i++) {
    //         if (cur + i >= N) break;
    //         dfs(cur + i);
    //     }

    //     for (int i = -1; i >= -stones[cur]; i--) {
    //         if (cur + i < 0) break;
    //         dfs(cur + i);
    //     }


    //     }
    // }

    private static void dfs(int cur) {
        if (visited[cur]) return;
        visited[cur] = true;

        if (cur + stones[cur] < N) {
            dfs(cur + stones[cur]);
        }

        if (cur - stones[cur] >= 0) {
            dfs(cur - stones[cur]);
        }
    }
}