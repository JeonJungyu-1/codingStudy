import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//게임 개발
//위상정렬

public class Main {
    static StringBuilder sb;
    static int N;
    static Node[] adjList;
    static int[] inDegree;
    static int[] costList;
    static int[] minCost;
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
        print();
    }
    
    private static void print() {
    }

    private static void solve() {
        ArrayList<Integer> list = topologySort();
        for (int i = 1; i < minCost.length; i++) {
            sb.append(minCost[i]).append("\n");
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
                minCost[temp.vertex] = Math.max(minCost[temp.vertex], minCost[cur] + costList[temp.vertex]);
            }
        }

        return orderList;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        adjList = new Node[N + 1];
        inDegree = new int[N + 1];
        costList = new int[N + 1];
        minCost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costList[i] = Integer.parseInt(st.nextToken());
            minCost[i] = costList[i];
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                if (from == -1) break;
                adjList[from] = new Node(i, adjList[from]);
                inDegree[i]++;
            }
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}