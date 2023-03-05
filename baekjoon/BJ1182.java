package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분수열의 합 - 브루트포스, 백트래킹
// 정렬해서 부분집합 사용
public class BJ1182 {
    static StringBuilder sb;
    static int N, S;
    static int[] numbers;
    static boolean[] isVisited;
    static int count;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() {
        Arrays.sort(numbers);
        subset(0, 0, 0);
    }

    private static void subset(int cnt, int sum, int trueCnt) {
        if (cnt == N) {
            if (sum == S && trueCnt != 0) count++;
            return;
        }

        isVisited[cnt] = true;
        subset(cnt + 1, sum + numbers[cnt], trueCnt + 1);
        isVisited[cnt] = false;
        subset(cnt + 1, sum, trueCnt);
        
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }





    }
}
