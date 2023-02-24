import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int T, M, C;
    static Node[] A, B;
    static chargeH[] chargeList;
    static int[] dr = {0,-1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int sum;
    static int[][] map;
    static boolean[][] isVisited;
    

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
            A = new Node[M + 1];
            B = new Node[M + 1];
            chargeList = new chargeH[C + 1];

            
            Node aNode = new Node(0, 0);
            Node bNode = new Node(9, 9);

            A[0] = new Node(aNode.r, aNode.c);
            B[0] = new Node(bNode.r, bNode.c);

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M + 1; i++) {
                int d = Integer.parseInt(st.nextToken());
                aNode.r += dr[d];
                aNode.c += dc[d];
                A[i] = new Node(aNode.r, aNode.c);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M + 1; i++) {
                int d = Integer.parseInt(st.nextToken());
                bNode.r += dr[d];
                bNode.c += dc[d];
                B[i] = new Node(bNode.r, bNode.c);
            }

            for (int i = 1; i < C + 1; i++) {
                st = new StringTokenizer(br.readLine());
                chargeList[i] = new chargeH(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            sum = 0;

            solve();

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 충전범위 3차원 배열에 각각 저장
    private static void solve() {
        // setCharge();
        explore();
    }


    // 한칸 갈 때마다 모든 충전기의 범위와 거리계산 해보기
    private static void explore() {
        List<chargeType> currentCharge = new ArrayList<>();
        for (int i = 0; i < M + 1; i++) {
            // System.out.println(sum);
            // System.out.println(A[i]);
            currentCharge.clear();

            for (int j = 1; j < chargeList.length; j++) {
                if (calDistance(A[i].r, A[i].c, chargeList[j].r, chargeList[j].c) > chargeList[j].distance) continue;
                currentCharge.add(new chargeType(1, chargeList[j].ch, j));
            }
            for (int j = 1; j < chargeList.length; j++) {
                if (calDistance(B[i].r, B[i].c, chargeList[j].r, chargeList[j].c) > chargeList[j].distance) continue;
                currentCharge.add(new chargeType(2, chargeList[j].ch, j));
            }

            int max = Integer.MIN_VALUE;
            if (currentCharge.size() == 1) {
                sum += currentCharge.get(0).ch;
            }  else if (currentCharge.size() > 1) {
                for (int j = 0; j < currentCharge.size(); j++) {
                    for (int k = j + 1; k < currentCharge.size(); k++) {
                        if (j == k) continue;
                        chargeType a = currentCharge.get(j);
                        chargeType b = currentCharge.get(k);
                        if (a.who != b.who) {
                            if (a.ch == b.ch) {
                                if (a.index == b.index) {
                                    max = Math.max(max, a.ch);
                                } else {
                                    max = Math.max(max, a.ch + b.ch);
                                }
                            } else {
                                max = Math.max(max, a.ch + b.ch);
                            }
                        } else {
                            max = Math.max(max, Math.max(a.ch, b.ch));
                        }
                    }
                }
                sum += max;
            }
        

        }
    }


    private static int calDistance(int r, int c, int nr, int nc) {
        return Math.abs(r - nr) + Math.abs(c - nc);
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


        @Override
        public String toString() {
            return "Node [r=" + r + ", c=" + c + ", ch=" + ch + "]";
        }

        
        
    }
    static class chargeType implements Comparable<chargeType> {
        int who;
        int ch;
        int index;
        public chargeType(int who, int ch, int index) {
            this.who = who;
            this.ch = ch;
            this.index = index;
        }
        @Override
        public int compareTo(chargeType o) {
            return Integer.compare(this.who, o.who);
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