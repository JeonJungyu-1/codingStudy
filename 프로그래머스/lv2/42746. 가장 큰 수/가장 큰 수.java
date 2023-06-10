import java.util.*;
class Solution {
    
    class Number implements Comparable<Number> {
        String n;
        
        public Number(String n) {
            this.n = n;
        }
        
        @Override
        public int compareTo(Number o) {
            return Integer.parseInt(o.n + this.n) - Integer.parseInt(this.n + o.n);
        }
    }
    
    public String solution(int[] numbers) {
        String answer = "";
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(new Number(String.valueOf(numbers[i])));
        }
        
        Collections.sort(list);
        
        if (Integer.parseInt(list.get(0).n) == 0) return "0";
        
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i).n;
        }
        
        
        
        return answer;
    }
}