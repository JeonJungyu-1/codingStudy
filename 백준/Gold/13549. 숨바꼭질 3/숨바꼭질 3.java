import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 3

public class Main {
    static StringBuilder sb;
    static int N, K;
    static int[] visited;
    static int minTime;
    static class Node {
        int r, time;

        public Node(int r, int time) {
            this.r = r;
            this.time = time;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minTime);
    }

    private static void solve() {
        bfs();
    }

    private static void bfs() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(N, 0));
        minTime = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.r == K) {
                minTime = Math.min(minTime, cur.time);
            }

            if (cur.r < K && visited[cur.r + 1] > cur.time + 1) {
                visited[cur.r + 1] = cur.time + 1;
                que.offer(new Node(cur.r + 1, cur.time + 1));
            }
            if (cur.r > 0 && visited[cur.r - 1] > cur.time - 1) {
                visited[cur.r - 1] = cur.time - 1;
                que.offer(new Node(cur.r - 1, cur.time + 1));
                
            } 
            if (cur.r < K && visited[cur.r * 2] > cur.time) {
                visited[cur.r * 2] = cur.time;
                que.offer(new Node(cur.r * 2, cur.time));
                
            }

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[200000];
        Arrays.fill(visited, Integer.MAX_VALUE);





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}