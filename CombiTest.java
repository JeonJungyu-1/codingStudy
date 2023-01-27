package com.ssafy.edu;

import java.util.Arrays;

// nCr 서로 다른 n개에서 서로 다른 r개를 선택
// 5C3 = 5 * 4 * 3/3!
// 완전탐색
public class CombiTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int N = p.length;
    static int R;
    static int[] nums;
    static int count;
    public static void main(String[] args) {
        R = 3;
        nums = new int[R];
        count = 0;

        combi(0, 0); // 재귀 -> 자신이 자신 호출 -> while -> dfs -> 끝나는 조건 필요
        System.out.println(count);
    }

    static void combi(int depth, int start) {
        if (depth == R) {
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }

        for (int i = start; i < N; i++) {
            // if (visited[i]) continue; 
            // 방문한 다음수 시작
            nums[depth] = p[i];
            combi(depth + 1, i + 1);
            nums[depth] = 0;
        }

    }
}
