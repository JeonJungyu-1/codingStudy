package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 순열
// 완벽한 순열이 되려면 그래프가 사이클을 이루어야 함
// 사이클 개수가 P와 Q의 차이
// B[0] = 0
// B[1] = A[0]
// B[2] = A[A[0]]
// B[3] = A[A[A[0]]]

public class BJ1115_2 {
    static int N;
    static int[] numbers;
    static boolean[] isVisited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(cnt == 1 ? 0 : cnt);
    }
    private static void solve() {
        cnt = 0;

        // 순열의 개수만큼 반복
        for (int i = 0; i < N; i++) {
            // 이미 방문한 숫자면 continue
            if (isVisited[i]) continue;
            int number = i;

            // 사이클 돌리기
            while (true) {
                // 사이클 다 돌아갔으면 break
                if (isVisited[number]) break;
                isVisited[number] = true;
                number = numbers[number];
            }
            cnt++;
        }

        
        

    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    
}
