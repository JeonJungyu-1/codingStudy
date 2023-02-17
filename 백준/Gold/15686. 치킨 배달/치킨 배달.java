import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int min;
    static List<Node> home;
    static List<Node> chicken;
    static Node[] selected;
    
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= M; i++) {
            selected = new Node[i];
            combi(0, 0, i);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
    }

    private static void combi(int cnt, int start, int r) {
        if (cnt == r) {
            int temp = 0;
            int lo = Integer.MAX_VALUE;
            for (int j = 0; j < home.size(); j++) {
                lo = Integer.MAX_VALUE;
                for (int i = 0; i < selected.length; i++) {
                    lo = Math.min(lo, cal(selected[i], home.get(j)));
                }
                temp += lo;
                
            }
            min = Math.min(min, temp);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            selected[cnt] = chicken.get(i);
            combi(cnt + 1, i + 1, r);
        }



        
    }

    private static int cal(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Node [r=" + r + ", c=" + c + "]";
        }

        
        
    }
}