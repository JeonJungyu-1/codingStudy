package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class processor2 {
    static int T, N;
    static int[][] map;
    static List<Node> coreList;
    static StringBuilder sb;
    static int minDistance;
    static int maxCore;

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        coreList.add(new Node(i, j));
                    }
                }
            }

            solve();


            sb.append("#").append(t).append(" ").append(minDistance).append("\n");
        }

        System.out.println(sb.toString());




    }

    
    private static void solve() {
        minDistance = Integer.MAX_VALUE;
        maxCore = -1;
        explore(0, map, 0, 0);

        if (minDistance == Integer.MAX_VALUE) {
            minDistance = 0;
        }


    }

    private static void explore(int cnt, int[][] m, int sumDistance, int core) {

        if (coreList.size() - cnt + core < maxCore) return;
        if (coreList.size() - cnt + core == maxCore && sumDistance > minDistance) return;
        
        if (cnt == coreList.size()) {
            // 코에 개수도 체크하기
            if (core > maxCore) {
                minDistance = sumDistance;
                maxCore = core;
            } else if (core == maxCore) {
                minDistance = Math.min(minDistance, sumDistance);
                
            }
            
            return;
        }

        Node node = coreList.get(cnt);

        
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                int[][] copyMap = mapCopy(m);
                int l = mapMove(node.r, node.c, i, copyMap);
                if (l != 0) {
                    explore(cnt + 1, copyMap, sumDistance + l, core + 1);
                }
            } else {
                explore(cnt + 1, m, sumDistance, core);
            }
        }
    }


    private static int[][] mapCopy(int[][] m) {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(m[i], N);
        }

        return copyMap;

    }


    
    // 0 면 받은 맵 그대로
    // 0 이상 면 바뀐 맵으로/ 그만큼 전선길이 늘리고 코어 한개 추가
    private static int mapMove(int r, int c, int d, int[][] copyMap) {
        
        int cnt = 0;
        switch (d) {
            case 0: // 상
                for (int i  = r - 1; i >= 0; i--) {
                    if (copyMap[i][c] != 0) return 0;
                    copyMap[i][c] = 2;
                    cnt++;
                }
                break;
            case 1: // 우
                for (int i = c + 1; i < N; i++) {
                    if (copyMap[r][i] != 0) return 0;
                    copyMap[r][i] = 2;
                    cnt++;
                }
                break;
            case 2: // 하
                for (int i = r + 1; i < N; i++) {
                    if (copyMap[i][c] != 0) return 0;
                    copyMap[i][c] = 2;
                    cnt++;
                }
                break;
            case 3: // 좌
                for (int i = c - 1; i >= 0; i--) {
                    if (copyMap[r][i] != 0) return 0;
                    copyMap[r][i] = 2;
                    cnt++;
                }
                break;
        }


        return cnt;

    }
}
