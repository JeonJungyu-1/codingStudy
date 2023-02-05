import java.util.*;

// 기능개발 - 큐 사용
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        // 받은 배열 큐로 변환
        Integer[] progress = Arrays.stream(progresses).boxed().toArray(Integer[]::new);
        Queue<Integer> progressQueue = new LinkedList<>(Arrays.asList(progress));
        
        Integer[] speed = Arrays.stream(speeds).boxed().toArray(Integer[]::new);
        Queue<Integer> speedQueue = new LinkedList<>(Arrays.asList(speed));
        
        
        int day = 1;
        int count = 0;
        
        // 작업이 남지 않을 때까지 반복
        while (!progressQueue.isEmpty()) {
            
            // 첫번째 작업률 계산
            int firstProgress = progressQueue.peek() + (day * speedQueue.peek());
            if (firstProgress >= 100) {
                progressQueue.poll();
                speedQueue.poll(); 
                count++;
                
                // 두번째 이상의 작업률 차례대로 계산해서 100이상이면 같이 처리
                while (!progressQueue.isEmpty()) {
                    int nextProgress = progressQueue.peek() + (day * speedQueue.peek());
                    if (nextProgress < 100) break;
                    
                    progressQueue.poll();
                    speedQueue.poll();
                    count++;
                }
                list.add(count);
                count = 0;   
            }
            day++;
        }
        
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
}