package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class charge {
    static int T, M, C;
    static int[] A, B;
    static Node aNode, bNode;
    static chargeH[] chargeList;
    static int[] dr = {0,-1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int aSum, bSum;
    static int[][][] map;
    static int[][] aMoveMap;
    static int[][] bMoveMap;
    static boolean[][] isVisited;
    static List<Same> aSame;
    static List<Same> bSame;
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        
    }

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            A = new int[M];
            B = new int[M];
            chargeList = new chargeH[C + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < C + 1; i++) {
                st = new StringTokenizer(br.readLine());
                chargeList[i] = new chargeH(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            map = new int[C + 1][10][10];
            aMoveMap = new int[10][10];
            bMoveMap = new int[10][10];
            aNode = new Node(0, 0);
            bNode = new Node(9, 9);
            aSame = new ArrayList<>();
            bSame = new ArrayList<>();

            aSum = 0;
            bSum = 0;

            solve();

            sb.append("#").append(t).append(" ").append(aSum + bSum).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 충전범위 3차원 배열에 각각 저장
    private static void solve() {
        exploreCharge();
        // move();


        // for (int i = 0; i < same.size(); i++) {
        //     Node node = same.get(i);
        // }

        // for (Node[] a: map) {
        //     for (Node n: a) {
        //         System.out.print(n);
        //     }
        //     System.out.println();
        //     // System.out.println(Arrays.toString(a));
        // } 

        // for (int[] q: aMoveMap) {
        //     System.out.println(Arrays.toString(q));
        // }
        // System.out.println();

        // for (int[] w: bMoveMap) {
        //     System.out.println(Arrays.toString(w));
        // }

        

        // for (int[][] a: map) {
        //     for (int[] b: a) {
        //         System.out.println(Arrays.toString(b));
        //     }
        //     System.out.println();
        // }
        
        // Collections.sort(aSame);
        // Collections.sort(bSame);
        // for (int i = 0; i < aSame.size(); i++) {
        //     for (int j = 0; j < bSame.size(); j++) {
        //         if (aSame.get(i).t == bSame.get(j).t) {
        //             if (i + 1 < aSame.size() && aSame.get(i).t == aSame.get(i + 1).t) {
                        
        //             }
        //             if (j + 1 < bSame.size() && bSame.get(i).t == bSame.get(i + 1).t) {

        //             }
        //         }
        //     }
        // }
        // for (Same s: aSame) {
        //     System.out.println(s);
        // }
        explore();
        // System.out.println(aSum);
        // System.out.println(bSum);
        
        
    }

    private static void move() {
        aMoveMap[aNode.r][aNode.c] = 1;
        bMoveMap[bNode.r][bNode.c] = 1;
        for (int i = 0; i < M; i++) {
            
            aNode.r += dr[A[i]];
            aNode.c += dc[A[i]];
            if (aMoveMap[aNode.r][aNode.c] == 0) {
                aMoveMap[aNode.r][aNode.c] = i + 1;
            }

            bNode.r += dr[B[i]];
            bNode.c += dc[B[i]];
            if (bMoveMap[bNode.r][bNode.c] == 0) {
                bMoveMap[bNode.r][bNode.c] = i + 1;
            }
        }
        

    }

    private static void explore() {
        int aNr = aNode.r;
        int aNc = aNode.c;

        int bNr = bNode.r;
        int bNc = bNode.c;
        
        List<chargeType> a = new ArrayList<>();
        List<chargeType> b = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            a.clear();
            b.clear();

            
            for (int j = 1; j < chargeList.length; j++) {
                if (map[j][aNr][aNc] > 0) {
                    a.add(new chargeType(j, map[j][aNr][aNc]));
                }
            }
            
            for (int j = 1; j < chargeList.length; j++) {
                if (map[j][bNr][bNc] > 0) {
                    b.add(new chargeType(j, map[j][bNr][bNc]));
                }
            }

            Collections.sort(a, Comparator.reverseOrder());
            Collections.sort(b, Comparator.reverseOrder());

            if (a.size() == 1 && b.size() == 1) {
                if (a.get(0).bc != b.get(0).bc) {
                    aSum += a.get(0).ch;
                    bSum += b.get(0).ch;
                    
                } else {
                    aSum += a.get(0).ch/2;
                    bSum += b.get(0).ch/2;

                }
            } else if (a.size() == 0 && b.size() >= 1) {
                bSum += b.get(0).ch;
            } else if (a.size() >= 1 && b.size() == 0) { 
                aSum += a.get(0).ch;

            } else if (a.size() >= 2 || b.size() >= 2) { 
                int m = Integer.MIN_VALUE;
                for (int j = 0; j < a.size(); j++) {
                    for (int k = 0; k < b.size(); k++) {
                        if (a.get(j).bc == b.get(k).bc) {
                            m = Math.max(m, a.get(j).ch);
                        } else {
                            m = Math.max(m, a.get(j).ch + b.get(k).ch);
                        }
                    }
                }

                aSum += m;
            }  

            // System.out.println(aSum);
            // System.out.println(bSum);
            // System.out.println(aSum);
            // System.out.println(bSum);

            // if (a.size() >= 1) {
            //     Collections.sort(a, Comparator.reverseOrder());
            //     aSum += a.get(0);
            //     a.clear();
            // }
            // if (b.size() >= 1) {
            //     Collections.sort(b, Comparator.reverseOrder());
            //     bSum += b.get(0);
            //     b.clear();
            // }


            if (i < M) {
                aNr += dr[A[i]];
                aNc += dc[A[i]];
    
                bNr += dr[B[i]];
                bNc += dc[B[i]];
            }
        }
        

    }

    private static void exploreCharge() {
        for (int i = 1; i < C + 1; i++) {
            bfs(i);
        }
    }

    private static void bfs(int index) {
        isVisited = new boolean[10][10];
        Queue<Node> que = new ArrayDeque<>();
        chargeH ch = chargeList[index];
        que.offer(new Node(ch.r, ch.c, 0));
        isVisited[ch.r][ch.c] = true;
        map[index][ch.r][ch.c] = ch.ch;

        while (!que.isEmpty()) {
            Node node = que.poll();

            
                // if (aMoveMap[node.r][node.c] > 0) {
                //     aSum += ch.ch;
                //     aSame.add(new Same(aMoveMap[node.r][node.c], ch.ch));
                //     // map[node.r][node.c] = 1;
                // }
                // if (bMoveMap[node.r][node.c] > 0) {
                //     bSum += ch.ch;
                //     bSame.add(new Same(bMoveMap[node.r][node.c], ch.ch));
                //     // map[node.r][node.c] = 2;
                // }

            
            
            // if (moveMap[node.r][node.c] == 3) {
            //     aSum += ch.ch/2;
            //     bSum += ch.ch/2;
            //     moveMap[node.r][node.c] = 3;
            // }

            for (int i = 1; i < 5; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (!mapcheck(nr, nc) || isVisited[nr][nc]) continue;
                if (calDistance(ch.r, ch.c, nr, nc) > ch.distance) continue;
                que.offer(new Node(nr, nc));
                isVisited[nr][nc] = true;
                map[index][nr][nc] = ch.ch;
                
            }
        }
        
    }

    private static boolean mapcheck(int r, int c) {
        return r >= 0 && r < 10 && c >= 0 && c < 10;
    }

    private static int calDistance(int r, int c, int nr, int nc) {
        return Math.abs(r - nr) + Math.abs(c - nc);
    }

    static class Same {
        int t;
        int ch;
        public Same(int t, int ch) {
            this.t = t;
            this.ch = ch;
        }
        @Override
        public String toString() {
            return "Same [t=" + t + ", ch=" + ch + "]";
        }


  

        
    }

    static class Node {
        int r;
        int c;
        int ch;
        

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }


        public Node(int r, int c, int ch) {
            this.r = r;
            this.c = c;
            this.ch = ch;
        }
        
    }

    static class chargeType implements Comparable<chargeType> {
        int bc;
        int ch;
        public chargeType(int bc, int ch) {
            this.bc = bc;
            this.ch = ch;
        }
        @Override
        public int compareTo(chargeType o) {
            // TODO Auto-generated method stub
            return this.ch - o.ch;
        }

        
        
    }

    static class chargeH {
        int r;
        int c;
        int distance;
        int ch;
        public chargeH(int c, int r, int distance, int ch) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.ch = ch;
        }
        
    }
}
