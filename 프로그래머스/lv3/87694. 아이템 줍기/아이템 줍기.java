import java.util.*;

class Solution {
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int k = 0; k < rectangle.length; k++) {
            rectangle[k][0] *= 2;
            rectangle[k][1] *= 2;
            rectangle[k][2] *= 2;
            rectangle[k][3] *= 2;
            
            for (int i = rectangle[k][0]; i <= rectangle[k][2]; i++) {
                for (int j = rectangle[k][1]; j <= rectangle[k][3]; j++) {
                    if (map[i][j] != -1 && (i == rectangle[k][0] || i == rectangle[k][2] || j == rectangle[k][1] || j == rectangle[k][3])) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = -1;
                    }
                    
                }
            }
        }
        
        
        answer = bfs(characterX, characterY, itemX, itemY);

        
        return answer;
    }
    
    public int bfs(int startR, int startC, int endR, int endC) {
        Queue<Node> que = new ArrayDeque<>();
        visited[startR][startC] = true;
        que.offer(new Node(startR, startC, 0));
        
        while (!que.isEmpty()) {
            Node cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr == endR && nc == endC) return (cur.d + 1)/2;
                if (visited[nr][nc] || map[nr][nc] != 1) continue;
                visited[nr][nc] = true;
                que.offer(new Node(nr, nc, cur.d + 1));
            }
        }
        
        
        
        
        return -1;
        
    }
    
    

    public boolean isInRange(int r, int c) {
        return r >= 0 && r <= 50 && c >= 0 && c <= 50;
    }
    
    class Node {
        int r, c, d;
        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
        
        public int compareTo(Node o) {
            return Integer.compare(this.r, o.r);
        }
    }
}

