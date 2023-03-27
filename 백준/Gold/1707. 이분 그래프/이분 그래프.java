import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 이분 그래프 - 인접한 정점끼리 서로 다른색으로 칠해서 모든 정점이 두가지 색으로 된 그래프
// 그래프 탐색
// 인접한 정점을 다른색으로 칠해 나감
// 인접한 정점이 같은 색이면 이분 그래프가 아님
// 연결 그래프, 비연결 그래프 모두 고려하기

public class Main {
    
    static StringBuilder sb;
    static List<List<Integer>> adjList;
    static int T, V, E;
    static int[] colors;
    static boolean isCollect;
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
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList<>();
            colors = new int[V + 1];

            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList.get(s).add(e);
                adjList.get(e).add(s);
            }

            isCollect = true;

            for (int i = 1; i <= V; i++) {
                if (!isCollect) break;
                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }

            if (isCollect) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        

    }


    private static void dfs(int pre, int color) {
        if (!isCollect) return;
        colors[pre] = color;
        for (Integer next : adjList.get(pre)) {
            if (colors[next] == color) {
                isCollect = false;
                return;
            }

            if (colors[next] == 0) {
                dfs(next, -color);
            }
        }
    }
}