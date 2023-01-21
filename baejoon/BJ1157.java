package baejoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class BJ1157 {
    static int max = -1;
    static char maxChar;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();

        // 받은 문자열 차례대로 맵에 저장
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // 저장된 문자들중 가장 개수가 큰 값 가져오기
        Iterator<Character> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            char key = keys.next();
            if (map.get(key) > max) {
                max = map.get(key);
                maxChar = key;
                count = 0;
            } else if (map.get(key) == max) {
                count++;
            }
        } 

        if (count > 0) {
            System.out.println("?");
        } else {
            System.out.println(maxChar);
        }
    }
}
