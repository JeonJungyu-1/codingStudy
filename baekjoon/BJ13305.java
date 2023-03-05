package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소 - 그리디
// 1. 이전 도시의 가격보다 낮거나 같으면 바로 계산
// 2. 이전 도시의 가격보다 높다면 낮거나 같은 도시가 나올때까지 거리 누적후에 계산
// int 범위 초과이기 때문에 long 사용
public class BJ13305 {
    static StringBuilder sb;
    static int N;
    static long[] distance, city;
    static long minPrice;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minPrice);
    }

    private static void solve() {
        long beforePrice = Integer.MAX_VALUE;
        long cumulativeDistance = 0;
        for (int i = 0; i < city.length; i++) {
            if (beforePrice >= city[i] || i == city.length - 1) {
                minPrice += (cumulativeDistance * beforePrice);
                beforePrice = city[i];
                cumulativeDistance = 0;
            }

            if (i < distance.length) cumulativeDistance += distance[i];
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        distance = new long[N - 1];
        city = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Long.parseLong(st.nextToken());
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
