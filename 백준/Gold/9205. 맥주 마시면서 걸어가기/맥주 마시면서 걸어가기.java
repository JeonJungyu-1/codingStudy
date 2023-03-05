import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기
// bfs
// 50미터마다 맥주를 마셔야 하고 20병까지 들 수 있으니까 1000미터마다 편의점이 있어야함
// 1000미터마다 갈 수 있는 편의점 체크하면서 도착할 수 있는지 탐색

public class Main {
    static int T, N;
    static Node[] nodeList;
    static StringBuilder sb;
    static boolean[] isVisited;

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            nodeList = new Node[N + 2];
            isVisited = new boolean[N + 2];
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                nodeList[i] = new Node(r, c);
            }


            solve();

        }
        System.out.println(sb.toString());

    }

    private static void solve() {
        explore();
    }

    private static void explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(nodeList[0]);
        boolean isSuccess = false;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 1; i < N + 2; i++) {
                Node next = nodeList[i];
                if (calDistance(cur, next) > 1000) continue;
                if (isVisited[i]) continue;
                
                if (i == N + 1) {
                    que.clear();
                    isSuccess = true;
                    break;
                }
                
                que.offer(next);
                isVisited[i] = true;
            }
        }

        if (isSuccess) {
            sb.append("happy");
        } else {
            sb.append("sad");
        }
        sb.append("\n");
    }

    private static int calDistance(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

   
}