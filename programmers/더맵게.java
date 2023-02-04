import java.util.PriorityQueue;
import java.util.Arrays;

// 더 맵게 - 힙(우선순위 큐 사용)
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐를 이용해서 가장 맵지 않은 음식부터 나오게 함.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int sco : scoville) {
            queue.offer(sco);
        }

        while (true) {
            if (queue.peek() >= K) {
                break;
            } else if (queue.size() <= 1) {
                answer = -1;
                break;
            }
            
            
            // 가장 맵지 않은 음식과 두번째로 맵지 않는 음식 조합하기
            int first = queue.poll();
            int second = queue.poll();
            int mix = first + (second * 2);
            
            queue.offer(mix);
            answer++;
        }
        
        return answer;
    }
}