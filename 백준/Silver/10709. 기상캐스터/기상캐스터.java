import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 기상캐스터

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        
    }
    
    static StringBuilder sb;
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
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<Node> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == 'c') {
                    que.offer(new Node(i, j));
                } else {
                    map[i][j] = -1;
                }
            }
        }

        int time = 1;
        while (!que.isEmpty()) {
            
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node n = que.poll();
                int nr = n.r;
                int nc = n.c + 1;
                if (!isInRange(nr, nc, N, M)) continue;

                if (map[nr][nc] == -1) {
                    map[nr][nc] = time;
                }
                que.offer(new Node(nr, nc));
            }

            time++;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static boolean isInRange(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}