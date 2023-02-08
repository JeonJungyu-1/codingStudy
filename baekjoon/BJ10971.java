package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
    static int[][] map;
    static boolean[] isVisited;
    static int[] city;
    static int N;
    static int minPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];
        city = new int[N + 1];
        minPrice = Integer.MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0);

        System.out.println(minPrice);

        
    }

    static void combi(int cnt) {
        if (cnt == N) {
            int price = 0;

            city[N] = city[0];
            for (int i = 0; i < N; i++) {
                if (map[city[i]][city[i + 1]] == 0) return;
                price += map[city[i]][city[i + 1]];
            }

            // System.out.println(price);
            minPrice = Math.min(price, minPrice);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;

            isVisited[i] = true;
            city[cnt] = i;
            combi(cnt + 1);
            city[cnt] = 0;
            isVisited[i] = false;

        } 
    }

}
