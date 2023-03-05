package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2567 {
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static Node[] list;
    static int perimeter;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(perimeter);
    }

    private static void solve() {
        for (int i = 0; i < list.length; i++) {
            draw(list[i]);
        }

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        if (mapCheck(i + dr[k], j + dc[k]) && map[i + dr[k]][j + dc[k]] == 0) {
                            cnt++;
                        }
                    }
                    perimeter += cnt;
                }
            }
        }


    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < 101 && c >= 0 && c < 101;
    }

    private static void draw(Node node) {
        for (int i = node.r; i < node.r + 10; i++) {
            for (int j = node.c; j < node.c + 10; j++) {
                if (mapCheck(i, j)) {
                    map[i][j] = 1;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new Node[N];
        map = new int[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new Node(r, c);
        }


    }
}
