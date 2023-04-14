class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        subset(0, 0, numbers, target);
        
        return answer;
    }
    
    public void subset(int cnt, int sum, int[] numbers, int target) {
        if (cnt == numbers.length) {
            if (target == sum) answer++;
            return;
        }
        
        subset(cnt + 1, sum + numbers[cnt], numbers, target);
        subset(cnt + 1, sum - numbers[cnt], numbers, target);
    }
}