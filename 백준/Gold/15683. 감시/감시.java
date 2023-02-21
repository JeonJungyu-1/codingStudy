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
    static List<Node> list;
    static int min;
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

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], M);
        }
        if (list.size() != 0) {
            explore(0, copyMap);
        } else {
            calMap(copyMap);
        }
    }
    private static void explore(int cnt, int[][] m) {
        if (cnt == list.size()) {
            calMap(m);
            return;
        }

        Node node = list.get(cnt);

        switch (node.num) {
            case 2:
                for (int i = 0; i < 2; i++) {
                    explore(cnt + 1, mapCopy(m, node, i));
                }
                break;
            case 1:
            case 3:
            case 4:
                for (int i = 0; i < 4; i++) {
                    explore(cnt + 1, mapCopy(m, node, i));
                }
                break;
            case 5:
                explore(cnt + 1, mapCopy(m, node, 0));                
                break;
        }

    }





    static int[][] mapCopy(int[][] m, Node node, int cnt) {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(m[i], M);
        }

        switch (node.num) {
            case 1:
                if (cnt == 0) { // 오른쪽
                    right(node, copyMap);
                } else if (cnt == 1) { // 왼쪽
                    left(node, copyMap);
                } else if (cnt == 2) { // 위쪽
                    up(node, copyMap);
                } else if (cnt == 3) { // 아래쪽
                    down(node, copyMap);
                }
                
                break;
            case 2:
                if (cnt == 0) { // 좌우
                    right(node, copyMap);
                    left(node, copyMap);
                } else if (cnt == 1) { // 위아래
                    up(node, copyMap);
                    down(node, copyMap);
                }
                
                break;
            case 3:
                if (cnt == 0) { // 위 오
                        right(node, copyMap);
                        up(node, copyMap);
                } else if (cnt == 1) { // 오 아
                        right(node, copyMap);
                        down(node, copyMap);
                } else if (cnt == 2) { // 왼 위
                        left(node, copyMap);
                        up(node, copyMap);
                   
                } else if (cnt == 3) { // 왼 아
                        left(node, copyMap);
                        down(node, copyMap);
                }
                break;
            case 4:
                if (cnt == 0) {
                        right(node, copyMap);
                        left(node, copyMap);
                        up(node, copyMap);
                    
                } else if (cnt == 1) {
                        right(node, copyMap);
                        left(node, copyMap);
                        down(node, copyMap);

                } else if (cnt == 2) {
                        right(node, copyMap);
                        up(node, copyMap);
                        down(node, copyMap);

                } else if (cnt == 3) {
                        left(node, copyMap);
                        up(node, copyMap);
                        down(node, copyMap);
                }
                break;
            case 5:
                right(node, copyMap);
                left(node, copyMap);
                down(node, copyMap);
                up(node, copyMap);
                
                break;

        }



        return copyMap;
    }
    private static void down(Node node, int[][] copyMap) {
        for (int i = node.r + 1; i < N; i++ ) {
            if (copyMap[i][node.c] == 6) break;  
            copyMap[i][node.c] = -1;
        }
    }
    private static void up(Node node, int[][] copyMap) {
        for (int i = node.r - 1; i >= 0; i-- ) {
            if (copyMap[i][node.c] == 6) break;  
            copyMap[i][node.c] = -1;
        }
    }
    private static void left(Node node, int[][] copyMap) {
        for (int i = node.c - 1; i >= 0; i-- ) {
            if (copyMap[node.r][i] == 6) break; 
            copyMap[node.r][i] = -1;
        }
    }
    private static void right(Node node, int[][] copyMap) {
        for (int i = node.c + 1; i < M; i++ ) {
            if (copyMap[node.r][i] == 6) break;
            copyMap[node.r][i] = -1;
        }
    }


    private static void calMap(int[][] m) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 0) {
                    cnt++;
                }
            }
        }
        
        min = Math.min(min, cnt);

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new Node(i, j, map[i][j]));
                }
            }
        }
    }

    

    static class Node {
        int r;
        int c;
        int num;
        public Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
        
    }
}