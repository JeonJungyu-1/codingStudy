import java.util.*;

class Solution {
    static Set<Integer> set;
    static String[] numberArr;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        
        numberArr = numbers.split("");
       
        
        
        // nP1 ... nPn
        // for (int i = 1; i <= numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            perm(0, "", numbers.length(), visited);
        // }        
        
        for (int number : set) {
            if (isPrime(number)) answer++;
        }
        
        return answer;
    }
    
    
    public boolean isPrime(int number) {
        if (number == 1 || number == 0) return false;
        
        double sqrt = Math.sqrt(number);
        
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
    
    public void perm(int cnt, String num, int n, boolean[] visited) {
        if (!num.equals("")) set.add(Integer.parseInt(num));

        if (cnt == n) {
            return;
        }
        
        
        for (int i = 0; i < numberArr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(cnt + 1, num + numberArr[i], n, visited);
            visited[i] = false;
        }
    }
}