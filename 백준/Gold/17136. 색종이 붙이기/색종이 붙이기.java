import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 색종이 붙이기

public class Main {
    
    static StringBuilder sb;
    static int[][] map;
    static int[] paper;
    static boolean[] visited;
    static int minCnt;
    static List<Node> nodeList;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);
    }

    private static void solve() throws IOException {
        init();
        minCnt = Integer.MAX_VALUE;
        visited = new boolean[6];

        perm(0, 0, 0);

        
        print();
    }

    private static int countSquare(int k) {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != 1) continue;
                if (checkSquare(i, j, k)) { 
                    if (paper[k] == 0) return cnt;
                    setSquare(i, j, k);
                    paper[k]--;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void perm(int cnt, int paperCnt, int all) {
        if (paperCnt >= minCnt) return;
        if (cnt == nodeList.size() || all == nodeList.size()) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == 1) {
                        return;
                    }
                }
            }
            minCnt = Math.min(minCnt, paperCnt);
            return;
        }



        Node cur = nodeList.get(cnt);
        if (map[cur.r][cur.c] != 1) {
            perm(cnt + 1, paperCnt, all);
        } else {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] == 0) {
                    continue;
                } else if (checkSquare(cur.r, cur.c, i)) { 
                    setSquare(cur.r, cur.c, i);
                    paper[i]--;
                    perm(cnt + 1, paperCnt + 1, all + (i * i));
                    paper[i]++;
                    initSquare(cur.r, cur.c, i);
                }
    
            }

        }

    }
    
    // private static void perm(int cnt, int paperCnt) {
    //     if (paperCnt >= minCnt) return;
    //     if (cnt == 5) {
    //         for (int i = 0; i < 10; i++) {
    //             for (int j = 0; j < 10; j++) {
    //                 if (map[i][j] == 1) {
    //                     return;
    //                 }
    //             }
    //         }
    //         minCnt = Math.min(minCnt, paperCnt);
    //         return;
    //     }
    //     int[][] copyMap = new int[10][10];
    //     for (int i = 0; i < 10; i++) {
    //         copyMap[i] = Arrays.copyOf(map[i], 10);
    //     }

    //     for (int i = 1; i <= 5; i++) {
    //         if (visited[i]) continue;
    //         visited[i] = true;
    //         int square = countSquare(i);
    //         perm(cnt + 1, paperCnt + square);
    //         paper[i] += square;
    //         initSquare(copyMap);
    //         visited[i] = false;
    //     }
    // }

    private static void initSquare(int r, int c, int k) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                map[i][j] = 1;
            }
        }
    }

    private static void setSquare(int r, int c, int k) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                map[i][j] = -1;
            }
        }
    }

    private static boolean checkSquare(int r, int c, int k) {
        
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                if (!isInRange(i, j) || map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < 10 && c >= 0 && c < 10;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new int[10][10];
        nodeList = new ArrayList<>(); 
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    nodeList.add(new Node(i, j));
                }
            }
        }
        paper = new int[6];
        Arrays.fill(paper, 5);


    }
}