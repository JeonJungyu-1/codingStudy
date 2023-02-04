package codingStudy.programmers;

import java.util.Arrays;

// 입국심사 - 이분탐색
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long start = 0;
        // 최대 걸리는 시간
        long end = (long)times[times.length - 1] * (long)n;
        long mid = -1;
        while (true) {
            if (start >= end) break;
        
            mid = (start + end) / 2;
            
            // 현재 중간값으로 심사가능한 사람 계산
            long people = 0;
            for (int i = 0; i < times.length; i++) {
                people += mid / (long)times[i];
            }
            
            // 계산한 사람수하고 기다리는 사람수를 비교
            if (people >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
                
        return end;
    }
}