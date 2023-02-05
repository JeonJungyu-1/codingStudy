import java.util.*;

// 같은 숫자는 싫어 - 스택/큐
public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int num = -1;
        for (int i = 0; i < arr.length; i++) {
            if (list.size() == 0 || (i != 0 && list.get(list.size() - 1) != arr[i])) {
                list.add(arr[i]);
            }
        }
        int[] answer = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}