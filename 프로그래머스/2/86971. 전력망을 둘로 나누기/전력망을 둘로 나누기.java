import java.util.*;
class Solution {
    static boolean[][] visited;
    static List<List<Integer>> adj;
    static int min;
    static int cnt;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        min = Integer.MAX_VALUE;
        
        visited = new boolean[n + 1][n + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        
        for (int i = 0; i < wires.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(visited[j], false);
            }
            visited[wires[i][0]][wires[i][1]] = true;
            visited[wires[i][1]][wires[i][0]] = true;
            cnt = 1;
            dfs(1);
            min = Math.min(min, Math.abs(n - 2 * cnt));
            
        }
        
        return min;
    }
    
    public void dfs(int cur) {
        
        
        for (int next : adj.get(cur)) {
            if (visited[cur][next] || visited[next][cur]) continue;
            cnt++;
            visited[cur][next] = true;
            visited[next][cur] = true;
            dfs(next);
        }
    }
}