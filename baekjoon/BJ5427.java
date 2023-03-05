package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 불 - bfs
// 1. 큐에다가 스타트 좌표를 넣고 처음 배치된 불의 좌표들을 넣는다.
// 2. bfs를 계속 돌리다가 테두리에 도착하면 끝내기
public class BJ5427 {
    static StringBuilder sb;
    static int T, N, M;
    static int[][] map;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static Node start;
    static Queue<Node> fireQue;
    static Node successNode;
    public static void main(String[] args) throws IOException {
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }



    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
    
            map = new int[N][M];
            fireQue = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (ch[j] == '#') {
                        map[i][j]  = 1;
                    } else if (ch[j] == '*') {
                        map[i][j] = 2;
                        fireQue.offer(new Node(i, j));
                    } else if (ch[j] == '@') {
                        map[i][j] = -1;
                        start = new Node(i, j, 1);
                    } else {
                        map[i][j] = 0;
                    } 
                }
            }



            explore();
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static void explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(start);
        que.addAll(fireQue);
        successNode = null;
        while (!que.isEmpty()) {
            Node node = que.poll();
            // 상근이가 탈출구에 도달했을 때
            if (endCheck(node.r, node.c) && map[node.r][node.c] == -1) {
                map[node.r][node.c] = -1;
                que.clear();
                successNode = new Node(node.r, node.c, node.time);
                break;
            }

            
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                // 맵을 벗어났으면
                if (!mapCheck(nr, nc)) continue;

                
                // 땅이거나 불일 때 상근이가 지나간 길인 경우만
                if (map[nr][nc] == 0 || (map[nr][nc] == -1 && map[node.r][node.c] == 2)) {
                    // 상근이면 타임도 같이 넣기
                    if (map[node.r][node.c] == -1) {
                        que.offer(new Node(nr, nc, node.time + 1));
                    } else {
                        que.offer(new Node(nr, nc));
                    }
                    map[nr][nc] = map[node.r][node.c];
                    
                }
                
            }

        }

        if (successNode == null) {
            sb.append("IMPOSSIBLE").append("\n");
        } else {
            sb.append(successNode.time).append("\n");
        }



    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static boolean endCheck(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == M - 1;
    }

    static class Node {
        int r;
        int c;
        int time;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        
        
    }
}
