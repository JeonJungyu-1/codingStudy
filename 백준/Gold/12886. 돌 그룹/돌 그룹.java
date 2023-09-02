import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

// 돌 그룹

public class Main {
    
    static StringBuilder sb;

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "a : "+ a + ", b : " + b + ", c : " + c;
        }

        
        
    }
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
        st = new StringTokenizer(br.readLine()) ;
        Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        boolean[][] visited = new boolean[2000][2000];

        boolean isAvailable = bfs(visited, start);
        System.out.println(isAvailable ? 1 : 0);
    }

    private static boolean bfs(boolean[][] visited, Node start) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(start.a, start.b, start.c));
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.a == cur.b && cur.b == cur.c && cur.a == cur.c) {
                return true;
            }

            if (visited[cur.a][cur.b]) continue;
            visited[cur.a][cur.b] = true;


            if (cur.a < cur.b) {
                que.offer(new Node(cur.a + cur.a, cur.b - cur.a, cur.c));
            } else if (cur.a > cur.b) {
                que.offer(new Node(cur.a - cur.b, cur.b + cur.b, cur.c));
            }

            if (cur.a < cur.c) {
                que.offer(new Node(cur.a + cur.a, cur.c - cur.a, cur.b));
            } else if (cur.a > cur.c) {
                que.offer(new Node(cur.a - cur.c, cur.c + cur.c, cur.b));
            }

            if (cur.c < cur.b) {
                que.offer(new Node(cur.c + cur.c, cur.b - cur.c, cur.a));
            } else if (cur.c > cur.b) {
                que.offer(new Node(cur.c - cur.b, cur.b + cur.b, cur.a));
            }


        }

        return false;


    }

    private static void calculateNode(int x, int y, int z, Node next) {        
        next = null;
        if (x < y) {
            System.out.println("??");
            next = new Node(x + x, y - x, z);
            System.out.println(next);
        } else if (x > y) {
            next = new Node(x - y, y + y, z);
        }
    }
}