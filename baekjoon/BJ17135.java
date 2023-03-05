package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17135 {
    // MC3 콤비네이션
    static int N, M, D;
    static int[][] map;
    static int[][] copyMap;
    static int max;
    static List<Node> enemy;
    static List<Node> arrow;
    static List<Node> removeEnemy;
    static List<Node> inputEnemy;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int distance;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.r == o.r ? this.c - o.c : o.r - this.r;
        }
        @Override
        public boolean equals(Object obj) {
            Node newNode = (Node)obj;
            return this.r == newNode.r && this.c == newNode.c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(max);
        
    }
    private static void solve() {
        max = Integer.MIN_VALUE;

        // 궁수 배치
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    arrow.clear();
                    arrow.add(new Node(N, i));
                    arrow.add(new Node(N, j));
                    arrow.add(new Node(N, k));
                    copyMap = new int[N + 1][M];
                    for (int l = 0; l < N + 1; l++) {
                        copyMap[l] = Arrays.copyOf(map[l], M);
                    }

                    enemy.clear();
                    for (int l = 0; l < inputEnemy.size(); l++) {
                        Node n = inputEnemy.get(l);
                        enemy.add(new Node(n.r, n.c));
                    }
                    

                    game();


                }
            }
        }

        
    }
    
    
    private static void game() {
        int cnt = 0;
        while (true) {
            if (enemy.size() == 0) break;
            
            // 궁수 공격
            for (int i = 0; i < arrow.size(); i++) {
                Node node = arrow.get(i);

                
                // 가까운 적 찾기 
                searchEnemy(node);
                
                
                
            }
            
            // 각각의 찾은 적 지우기(removeEnemy)
            
            // 여기서 enemy에서 삭제해주기
            
            for (int j = 0; j < removeEnemy.size(); j++) {
                Node no = removeEnemy.get(j);
                if (copyMap[no.r][no.c] == 1) {
                    cnt++;
                    copyMap[no.r][no.c] = 0;
                    enemy.remove(no);
                }
            }
            removeEnemy.clear();
            
            
            
            //한칸씩 아래로 감
            moveEnemy();
    
        }
        
        max = Math.max(max, cnt);
    }

    // private static void searchEnemy(Node node) {
    //     Queue<Node> que = new ArrayDeque<>();
    //     boolean[][] isVisited = new boolean[N + 1][M];
    //     que.offer(new Node(node.r, node.c, 0));
    //     int minDistance = D;
    //     List<Node> tempList = new ArrayList<>();
    //     while (!que.isEmpty()) {
    //         Node ene = que.poll();

    //         for (int i = 0; i < 4; i++) {
    //             int nr = ene.r + dr[i];
    //             int nc = ene.c + dc[i];
    //             if (!mapCheck(nr, nc) || isVisited[nr][nc] || copyMap[nr][nc] != 1) continue;
    //             int tempDistance = calDistance(ene.r, ene.c, nr, nc);
    //             if (tempDistance > minDistance) continue;
    //             minDistance = tempDistance;
    //             que.offer(new Node(nr, nc, tempDistance + 1));
    //             tempList.add(new Node(nr, nc));
    //             isVisited[nr][nc] = true;
    //         }

    //     }

    //     if (tempList.size() == 1) {
    //         removeEnemy.addAll(tempList);
    //     } else if (tempList.size() >= 2) {
    //         Collections.sort(tempList);
    //         removeEnemy.add(tempList.get(0));
    //     }
    // }


    private static void searchEnemy(Node node) {

        // 이전거랑 비교해서 낮으면 버리기
        Node removeNode = null;
        for (int i = 0; i < enemy.size(); i++) {
            Node ene = enemy.get(i);
            // 궁수와 적과의 거리가 거리 제한보다 작거나 같으면
            int eneDistance = calDistance(ene.r, ene.c, node.r, node.c);
            if (eneDistance <= D) {
                if (removeNode == null) {
                    removeNode = new Node(ene.r, ene.c, eneDistance);
                } else {
                    if (removeNode.distance > eneDistance) {
                        removeNode = new Node(ene.r, ene.c, eneDistance);
                    } else if (removeNode.distance == eneDistance) {
                        if (removeNode.c > ene.c) {
                            removeNode = new Node(ene.r, ene.c, eneDistance);
                        }
                    }
                }
            }

        }

        if (removeNode != null) {
            removeEnemy.add(removeNode);
        }

    }


    private static void moveEnemy() {
        Collections.sort(enemy);
        for (int i = 0; i < enemy.size(); i++) {
            Node node = enemy.get(i);
            if (node.r + 1 < N) {
                copyMap[node.r + 1][node.c] = 1;
                copyMap[node.r][node.c] = 0;
                node.r += 1;
            } else {
                copyMap[node.r][node.c] = 0;
                enemy.remove(node);
                i--;
            }
        }
    }

    private static int calDistance(int r, int c, int nr, int nc) {
        return Math.abs(r - nr) + Math.abs(c - nc);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M];
        enemy = new ArrayList<>();
        arrow = new ArrayList<>();
        removeEnemy = new ArrayList<>();
        inputEnemy = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    inputEnemy.add(new Node(i, j, 0));
                }
            }
        }
    }
}
