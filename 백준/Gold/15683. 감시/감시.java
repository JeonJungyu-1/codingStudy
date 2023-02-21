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
            case 1:
                explore(cnt + 1, mapCopy(m, node, 0));
                explore(cnt + 1, mapCopy(m, node, 1));
                explore(cnt + 1, mapCopy(m, node, 2));
                explore(cnt + 1, mapCopy(m, node, 3));
                break;
            case 2:
            explore(cnt + 1, mapCopy(m, node, 0));
            explore(cnt + 1, mapCopy(m, node, 1));
                
                break;
            case 3:
            explore(cnt + 1, mapCopy(m, node, 0));
            explore(cnt + 1, mapCopy(m, node, 1));
            explore(cnt + 1, mapCopy(m, node, 2));
            explore(cnt + 1, mapCopy(m, node, 3));
                
                break;
            case 4:
            explore(cnt + 1, mapCopy(m, node, 0));
            explore(cnt + 1, mapCopy(m, node, 1));
            explore(cnt + 1, mapCopy(m, node, 2));
            explore(cnt + 1, mapCopy(m, node, 3));
                
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
                    for (int i = node.c + 1; i < M; i++ ) {
                        if (copyMap[node.r][i] == 6) break;
                        if (copyMap[node.r][i] != 0) continue;
                        copyMap[node.r][i] = -1;
                    }
                } else if (cnt == 1) { // 왼쪽
                    for (int i = node.c - 1; i >= 0; i-- ) {
                        if (copyMap[node.r][i] == 6) break; 
                        if (copyMap[node.r][i] != 0) continue;
                        copyMap[node.r][i] = -1;
                    }
                } else if (cnt == 2) { // 위쪽
                    for (int i = node.r - 1; i >= 0; i-- ) {
                        if (copyMap[i][node.c] == 6) break;  
                        if (copyMap[i][node.c] != 0) continue;
                        copyMap[i][node.c] = -1;
                    }
                } else if (cnt == 3) { // 아래쪽
                    for (int i = node.r + 1; i < N; i++ ) {
                        if (copyMap[i][node.c] == 6) break;  
                        if (copyMap[i][node.c] != 0) continue;
                        copyMap[i][node.c] = -1;
                    }
                }
                
                break;
            case 2:
                if (cnt == 0) { // 좌우
                    for (int i = node.c + 1; i < M; i++ ) {
                        if (copyMap[node.r][i] == 6) break; 
                        if (copyMap[node.r][i] != 0) continue;
                        copyMap[node.r][i] = -1;
                    }
                    for (int i = node.c - 1; i >= 0; i-- ) {
                        if (copyMap[node.r][i] == 6) break; 
                        if (copyMap[node.r][i] != 0) continue;
                        copyMap[node.r][i] = -1;
                    }
                } else if (cnt == 1) { // 위아래
                    for (int i = node.r - 1; i >= 0; i-- ) {
                        if (copyMap[i][node.c] == 6) break;  
                        if (copyMap[i][node.c] != 0) continue;
                        copyMap[i][node.c] = -1;
                    }
                    for (int i = node.r + 1; i < N; i++ ) {
                        if (copyMap[i][node.c] == 6) break;  
                        if (copyMap[i][node.c] != 0) continue;
                        copyMap[i][node.c] = -1;
                    }
                }
                
                break;
            case 3:
                if (cnt == 0) { // 위 오
                        for (int i = node.c + 1; i < M; i++ ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                    
                        for (int i = node.r - 1; i >= 0; i-- ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                    
                } else if (cnt == 1) { // 오 아
                        for (int i = node.c + 1; i < M; i++ ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                    
                        for (int i = node.r + 1; i < N; i++ ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                    

                } else if (cnt == 2) { // 왼 위

              
                        for (int i = node.c - 1; i >= 0; i-- ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        for (int i = node.r - 1; i >= 0; i-- ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                   
                } else if (cnt == 3) { // 왼 아
                    
                        for (int i = node.c - 1; i >= 0; i-- ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                   
                        for (int i = node.r + 1; i < N; i++ ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                    
                }
                break;
            case 4:
                if (cnt == 0) {
                        for (int i = node.c + 1; i < M; i++ ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        for (int i = node.c - 1; i >= 0; i-- ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        for (int i = node.r - 1; i >= 0; i-- ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                    
                } else if (cnt == 1) {
                        for (int i = node.c + 1; i < M; i++ ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        for (int i = node.c - 1; i >= 0; i-- ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                    
                        for (int i = node.r + 1; i < N; i++ ) {
                            if (copyMap[i][node.c]== 6) break;
                            copyMap[i][node.c] = -1;
                        }

                } else if (cnt == 2) {
                        for (int i = node.c + 1; i < M; i++ ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        
                        for (int i = node.r - 1; i >= 0; i-- ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                        for (int i = node.r + 1; i < N; i++ ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }

                } else if (cnt == 3) {
                        
                        for (int i = node.c - 1; i >= 0; i-- ) {
                            if (copyMap[node.r][i] == 6) break; 
                            if (copyMap[node.r][i] != 0) continue;
                            copyMap[node.r][i] = -1;
                        }
                        for (int i = node.r - 1; i >= 0; i-- ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                        for (int i = node.r + 1; i < N; i++ ) {
                            if (copyMap[i][node.c] == 6) break;  
                            if (copyMap[i][node.c] != 0) continue;
                            copyMap[i][node.c] = -1;
                        }
                }
                break;
            case 5:
                for (int i = node.c + 1; i < M; i++ ) {
                    if (copyMap[node.r][i] == 6) break; 
                    if (copyMap[node.r][i] != 0) continue;
                    copyMap[node.r][i] = -1;
                }
                for (int i = node.c - 1; i >= 0; i-- ) {
                    if (copyMap[node.r][i] == 6) break; 
                    if (copyMap[node.r][i] != 0) continue;
                    copyMap[node.r][i] = -1;
                }
                for (int i = node.r - 1; i >= 0; i-- ) {
                    if (copyMap[i][node.c]== 6) break;
                    copyMap[i][node.c] = -1;
                }
                for (int i = node.r + 1; i < N; i++ ) {
                    if (copyMap[i][node.c] == 6) break;  
                    if (copyMap[i][node.c] != 0) continue;
                    copyMap[i][node.c] = -1;
                }
            
                
                break;

        }



        return copyMap;
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
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

        
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(m[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
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