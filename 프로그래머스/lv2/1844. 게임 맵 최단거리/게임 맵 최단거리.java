import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    class Node {
        int r, c, t;
        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int solution(int[][] maps) {        
        int answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(0, 0, 1));
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int result = -1;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c]  = true;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (!isInRange(nr, nc, maps.length, maps[0].length) || maps[nr][nc] == 0) continue;
                if (nr == maps.length - 1 && nc == maps[0].length - 1) {
                    result = cur.t + 1;
                    que.clear();
                    break;
                }

                que.offer(new Node(nr, nc, cur.t + 1));
            }
            
        }
        
        
        return result;
        
    
    }
    
    public boolean isInRange(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}