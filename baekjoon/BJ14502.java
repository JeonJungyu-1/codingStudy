package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
// 완전탐색(조합), bfs

public class BJ14502 {
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static int[][] virusMap;
    static Queue<Node> que;
    static List<Node> safeList;
    static int minVirus;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
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
        print();
    }
    
    private static void print() {
        int maxSafe = safeList.size() - 3 - minVirus;
        System.out.println(maxSafe);
    }

    private static void solve() {
        minVirus = Integer.MAX_VALUE;
        for (int i = 0; i < safeList.size(); i++) {
            for (int j = i + 1; j < safeList.size(); j++) {
                for (int k = j + 1; k < safeList.size(); k++) {

                    Node one = safeList.get(i);
                    Node two = safeList.get(j);
                    Node three = safeList.get(k);
                    
                    map[one.r][one.c] = 1;
                    map[two.r][two.c] = 1;
                    map[three.r][three.c] = 1;

                    int virusCnt = virus();
                    minVirus = Math.min(minVirus, virusCnt);

                    map[three.r][three.c] = 0;
                    map[two.r][two.c] = 0;
                    map[one.r][one.c] = 0;

                }
            }
        }
    }

    private static int virus() {
        Queue<Node> newQue = new ArrayDeque<>();
        newQue.addAll(que);
        int cnt = 0;
        virusMap = new int[N][M];
        while (!newQue.isEmpty()) {
            int size = newQue.size();

            for (int i = 0; i < size; i++) {
                Node node = newQue.poll();
    
                for (int j = 0; j < 4; j++) {
                    int nr = node.r + dr[j];
                    int nc = node.c + dc[j];
                    if (!mapCheck(nr, nc) || map[nr][nc] != 0 || virusMap[nr][nc] == 2) continue;
                    virusMap[nr][nc] = 2;
                    newQue.offer(new Node(nr, nc));
                    cnt++;

                    if (cnt > minVirus) return cnt;
                }

            }
            
        }

        return cnt;
    }

    private static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        que = new ArrayDeque<>();
        safeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    que.offer(new Node(i, j));
                } else if (map[i][j] == 0) {
                    safeList.add(new Node(i, j));
                }
            }
        }

    }
}
