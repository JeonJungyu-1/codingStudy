import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 4
// bfs

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static boolean[] visited;
    static int[] route;
    static int minTime;
    static class Node {
        int r, t;
        public Node(int r, int t) {
            this.r = r;
            this.t = t;
        }

    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    // private static void print() {
    //     for (int next = K; route[next] != -1; next = route[next]) {
    //         sb.insert(0, next + " ");
    //     }
    //     sb.insert(0, minTime + "\n" + N + " ");
    //     System.out.println(sb.toString());
    // }
    private static void print() {
        sb.append(minTime).append("\n");
        for (int next = N; route[next] != -1; next = route[next]) {
            sb.append(next).append(" ");
        }
        sb.append(K);
        System.out.println(sb.toString());
    }

    private static void solve() {
        bfs();
    }

    // private static void bfs() {
    //     Queue<Node> que = new ArrayDeque<>();
    //     Arrays.fill(route, -1);
    //     que.offer(new Node(N, 0));
    //     visited[N] = true;

    //     while (!que.isEmpty()) {
    //         Node cur = que.poll();
    //         if (cur.r == K) {
    //             minTime = cur.t;
    //             break;
    //         }

    //         if (cur.r + 1 <= 100000 && !visited[cur.r + 1]) {
    //             visited[cur.r + 1] = true;
    //             route[cur.r + 1] = cur.r;
    //             que.offer(new Node(cur.r + 1, cur.t + 1));
    //         }

    //         if (cur.r - 1 >= 0 && !visited[cur.r - 1]) {
    //             visited[cur.r - 1] = true;
    //             route[cur.r - 1] = cur.r;
    //             que.offer(new Node(cur.r - 1, cur.t + 1));
    //         }

    //         if (cur.r * 2 <= 100000 && !visited[cur.r * 2]) {
    //             visited[cur.r * 2] = true;
    //             route[cur.r * 2] = cur.r;
    //             que.offer(new Node(cur.r * 2, cur.t + 1));
    //         }

            
    //     }
    // }

    // K부터 N까지로 탐색하기 (출력시간 줄이기 위해서)
    private static void bfs() {
        Queue<Node> que = new ArrayDeque<>();
        Arrays.fill(route, -1);
        que.offer(new Node(K, 0));
        visited[K] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.r == N) {
                minTime = cur.t;
                break;
            }

            if (cur.r + 1 <= 100000 && !visited[cur.r + 1]) {
                visited[cur.r + 1] = true;
                route[cur.r + 1] = cur.r;
                que.offer(new Node(cur.r + 1, cur.t + 1));
            }

            if (cur.r - 1 >= 0 && !visited[cur.r - 1]) {
                visited[cur.r - 1] = true;
                route[cur.r - 1] = cur.r;
                que.offer(new Node(cur.r - 1, cur.t + 1));
            }

            if (cur.r / 2 <= 100000 && !visited[cur.r / 2] && cur.r % 2 == 0) {
                visited[cur.r / 2] = true;
                route[cur.r / 2] = cur.r;
                que.offer(new Node(cur.r / 2, cur.t + 1));
            }

            
        }
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        route = new int[100001];





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}