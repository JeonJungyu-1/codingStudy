package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 벌꿀채취 {
    static int T, N, M, C;
    static int[][] map;
    static StringBuilder sb;
    static int[] honey;
    static List<Honey> honeyList;
    static int maxHoney;
    static int resultHoney;
    
    static class Honey implements Comparable<Honey> {
        int r, c, w;

        public Honey(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Honey o) {
            return Integer.compare(o.w, this.w);
        }

        @Override
        public String toString() {
            return "Honey [r=" + r + ", c=" + c + ", w=" + w + "]";
        }

        

        
        
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            honey = new int[M];
            honeyList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            resultHoney = 0;


            solve();
            
            sb.append("#").append(t).append(" ").append(resultHoney).append("\n");
        }

        System.out.println(sb.toString());
    }
    private static void solve() {
        
        //각각의 벌꿀은 부분조합 / 가지치기 잘해주기
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         if (j + M - 1 > N - 1) continue;
        //         for (int i2 = 0; i2 < N; i2++) {
        //             for (int j2 = 0; j2 < N; j2++) {
        //                 if (i > i2 || (i == i2 && j >= j2)) continue;
        //                 if (i == i2 && j + M - 1 <= j2) continue;
        //                 if (j2 + M - 1 > N - 1) continue;
        //                 // 1번 벌꿀채취
        //                 subset(0, 0);

        //                 // 2번 벌꿀채취
        //             }
        //         }
        //     }
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + M - 1 > N - 1) continue;

                // 벌꿀채취
                for (int k = 0; k < M; k++) {
                    honey[k] = map[i][j + k];
                }
                maxHoney = Integer.MIN_VALUE;
                subset(0, 0, 0);
                honeyList.add(new Honey(i, j, maxHoney));
            }
        }

        Collections.sort(honeyList);


        for (int i = 0; i < honeyList.size(); i++) {
            for (int j = 0; j < honeyList.size(); j++) {
                if (i == j) continue;
                Honey one = honeyList.get(i);
                Honey two = honeyList.get(j);
                if (one.r != two.r) {
                    resultHoney += (one.w + two.w);
                    return;
                } else {
                    if (Math.abs(one.c - two.c) < M) continue;
                    resultHoney += (one.w + two.w);
                    return;
                }
            }
        }

    }


    private static void subset(int cnt, int sum, int sumHoney) {
        if (sum >= C) {
            if (sum == C) maxHoney = Math.max(maxHoney, sumHoney);
            return;
        }
        if (cnt == M) {
            if (sum <= C) maxHoney = Math.max(maxHoney, sumHoney);
            return;
        }

        subset(cnt + 1, sum + honey[cnt], sumHoney + (honey[cnt] * honey[cnt]));
        subset(cnt + 1, sum, sumHoney);


    }
}
