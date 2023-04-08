import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM Craft
// 위상정렬

public class Main {
    
    static StringBuilder sb;
    static int T, N, M;
    static Node[] adjList;
    static int[] inDegree;
    static int[] time;
    static int[] minTime;
    static int endPoint;
    static class Node {
        int vertex;
        Node link;
        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adjList = new Node[N + 1];
            inDegree = new int[N + 1];
            time = new int[N + 1];
            minTime = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                minTime[i] = time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
                inDegree[to]++;
            }
            endPoint = Integer.parseInt(br.readLine());
            topologySort();
            sb.append(minTime[endPoint]).append("\n");
        }

        System.out.println(sb.toString());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static void topologySort() {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) que.offer(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if (--inDegree[temp.vertex] == 0) {
                    que.offer(temp.vertex);
                }
                minTime[temp.vertex] = Math.max(minTime[cur] + time[temp.vertex], minTime[temp.vertex]);
            }
            
        }
    }
}