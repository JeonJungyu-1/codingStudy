import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 이모티콘
// bfs

public class Main {
    
    static StringBuilder sb;
    static int S;
    static boolean[][] visited;
    static class Node {
        int r, save;

        public Node(int r, int save) {
            this.r = r;
            this.save = save;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }


    private static void solve() {
        int result = explore();
        System.out.println(result);
    }

    private static int explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(1, 0));
        visited[1][0] = true;
        int time = 0;
        a:
        while (!que.isEmpty()) {
            int size = que.size();
            
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                
                if (cur. r == S) {
                    break a;
                }

                if (!visited[cur.r][cur.r]) {
                    que.offer(new Node(cur.r, cur.r));
                    visited[cur.r][cur.r] = true;
                }

                if (cur.r + cur.save <= S && !visited[cur.r + cur.save][cur.save]) {
                    que.offer(new Node(cur.r + cur.save, cur.save));
                    visited[cur.r + cur.save][cur.save] = true;
                }

                if (cur.r - 1 >= 0 && !visited[cur.r - 1][cur.save]) {
                    que.offer(new Node(cur.r - 1, cur.save));
                    visited[cur.r - 1][cur.save] = true;
                }
            }
            time++;
        }

        return time;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        S = Integer.parseInt(br.readLine());
        visited = new boolean[S + 1][S + 1];

    }
}