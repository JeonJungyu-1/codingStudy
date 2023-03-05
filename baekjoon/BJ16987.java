package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 계란으로 계란치기
// 브루트포스, 백트래킹 문제
// 문제 설명대로만 구현하면 됨 (문제 꼼꼼히 읽기)
public class BJ16987 {
    static int N, S, W;
    static Egg[] eggList;
    static int max;
    public static void main(String[] args) throws IOException {
        init();        
        solve();
        print();
    }

    private static void print() {
        System.out.println(max);
    }

    private static void solve() {
        max = Integer.MIN_VALUE;
        egg(0);
        
    }

    private static void egg(int cnt) {
        if (cnt == N) {
            max = Math.max(max, breakCount());
            return;
        }

        int attack = 0;
        for (int i = 0; i < N; i++) {
            if (i == cnt) continue;
            if (eggList[cnt].s <= 0) {
                egg(cnt + 1);
                break;
            }

            if (eggList[i].s > 0 && eggList[cnt].s > 0) {
                eggList[i].s -= eggList[cnt].w;
                eggList[cnt].s -= eggList[i].w;
                egg(cnt + 1);
                attack++;
                eggList[cnt].s += eggList[i].w;
                eggList[i].s += eggList[cnt].w;
            }
        }

        if (attack == 0) {
            egg(cnt + 1);
        }


    }

   
    private static int breakCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (eggList[i].s <= 0) count++;
        }
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggList = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggList[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

    }

    static class Egg {
        int s;
        int w;
        int index;
        public Egg(int s, int w, int index) {
            this.s = s;
            this.w = w;
            this.index = index;
        }
        
    }


}

