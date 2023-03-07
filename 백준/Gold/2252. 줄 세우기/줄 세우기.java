import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄세우기
// 위상정렬

public class Main {
    static StringBuilder sb;
    static int N, M;
    static Node[] adjList;
    static int[] inDegree;
    static class Node {
        int vertex;
        Node link;
        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    
 
    private static void solve() {
        ArrayList<Integer> list = topologySort();
        for (Integer vertex : list) {
            sb.append(vertex).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            orderList.add(cur);

            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if (--inDegree[temp.vertex] == 0) {
                    queue.offer(temp.vertex);
                }
            }
        }
        return orderList;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new Node[N + 1];
        inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }



    }
}