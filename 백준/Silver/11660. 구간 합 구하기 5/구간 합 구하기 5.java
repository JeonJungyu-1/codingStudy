import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] sum;
    static Node[] nodeList;

    static class Node {
        int startR, startC, endR, endC;

        public Node(int startR, int startC, int endR, int endC) {
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
        }

        
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }


    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (Node cur : nodeList) {
            int s = map[cur.endR][cur.endC] - (map[cur.startR - 1][cur.endC] + map[cur.endR][cur.startC - 1] - map[cur.startR - 1][cur.startC - 1]);
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }


    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        sum = new int[N + 1][N + 1];
        nodeList = new Node[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            nodeList[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}