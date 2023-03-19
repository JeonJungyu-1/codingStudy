import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쿠키의 신체 측정

public class Main {
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static Node head;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        Node heart = new Node(head.r + 1, head.c);
        sb.append(heart.r).append(" ").append(heart.c).append("\n");
        int cnt = 0;
        // 왼팔
        for (int i = 1; i < heart.c; i++) {
            if (map[heart.r][i] == 1) {
                cnt++;
            }
        }
        sb.append(cnt).append(" ");
        
        cnt = 0;
        // 오른팔
        for (int i = heart.c + 1; i <= N; i++) {
            if (map[heart.r][i] == 1) {
                cnt++;
            }
        }
        sb.append(cnt).append(" ");
        
        int midCnt = 0;
        // 허리
        for (int i = heart.r + 1; i <= N; i++) {
            if (map[i][heart.c] == 1) {
                midCnt++;
            }
        }
        sb.append(midCnt).append(" ");
        
        cnt = 0;
        // 왼다리
        for (int i = heart.r + midCnt + 1; i <= N; i++) {
            if (map[i][heart.c - 1] == 1) {
                cnt++;
            }
        }
        sb.append(cnt).append(" ");
        
        cnt = 0;
        // 오른다리
        for (int i = heart.r + midCnt + 1; i <= N; i++) {
            if (map[i][heart.c + 1] == 1) {
                cnt++;
            }
        }
        sb.append(cnt).append(" ");

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        head = null;
        for (int i = 1; i <= N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++){
                if (ch[j - 1] == '_') {
                    map[i][j] = 0;
                } else {
                    if (head == null) head = new Node(i, j);
                    map[i][j] = 1;
                }
            }
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}