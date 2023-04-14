import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 좌표 정렬하기 2

public class Main {
    static int N;
    static class Node implements Comparable<Node> {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            int compare = Integer.compare(this.c, o.c);
            return compare == 0 ? Integer.compare(this.r, o.r) : compare;
        }

        
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            sb.append(cur.r).append(" ").append(cur.c).append("\n");
        }

        System.out.println(sb.toString());

    }
}