package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9205 {
    static int T;
    static int[][] map;
    static boolean[][] isVisited;
    static int N;
    static int maxN;
    static int beer;
    static Node beerNode;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static String result;
    // 집은 1, 편의점은 2, 페스티벌은 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        maxN = Integer.MIN_VALUE;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[10000][10000];
            isVisited = new boolean[10000][10000];
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            beer = 20;
            beerNode = new Node(r, c, 20);
            result = "";
    
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                map[r][c] = 2;
            }
    
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r][c] = 3;
            explore();
    
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());



    }

    static void explore() {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(beerNode.r, beerNode.c));
        isVisited[beerNode.r][beerNode.c] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                //맵을 벗어났거나 방문한 장소이면 continue
                if (!mapCheck(nr, nc) || isVisited[nr][nc]) continue;
                

                
                if (map[nr][nc] == 3 && beerNode.b >= 0) { // 목적지에 도착하면
                    System.out.println(beerNode.b);
                    result = "happy";
                    return;
                } else if (map[nr][nc] == 2) { // 편의점에 도착하면 맥주 보급
                    System.out.println(beerNode.b);
                    // beer = 20;
                    beerNode.b = 20;
                }
                
                // 맥주 마시기
                eatBeer(nr, nc);
                if (beerNode.b < 0) {
                    System.out.println(beerNode.b);
                    result = "sad";
                    continue;
                }
                isVisited[nr][nc] = true;
                que.add(new Node(nr, nc));
            }
        }
        
    }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < 10000 && c >= 0 && c < 10000;
    }


    // 맥주 마시기
    static void eatBeer(int r, int c) {
        // if (beer == 0) return;
        int nr = Math.abs(r - beerNode.r);
        int nc = Math.abs(c - beerNode.c);
        // 50미터에 도달했으면
        if (nr + nc == 50) {
            beerNode = new Node(nr, nc, beerNode.b - 1);
        }

    }

    static class Node {
        int r;
        int c;
        int b;
        public Node(int r, int c, int b) {
            this.r = r;
            this.c = c;
            this.b = b;
        }
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
}
