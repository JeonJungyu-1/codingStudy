package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Privacy {
    static Map<String, String> map = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {

        // 유효기간을 맵에 저장
        for (String term: terms) {
            String[] str = term.split(" ");
            map.put(str[0], str[1]);
        }
        

        // 개인정보별로 유효기간 저장
        for (int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");

            boolean compare = compareDate(today, str[0], map.get(str[1]));

            if (compare) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean compareDate(String a, String b, String add) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Date aDate = dateFormat.parse(a);
            Date bDate = dateFormat.parse(b);

            // 유효기간 더하기
            Calendar cal = Calendar.getInstance();
            cal.setTime(bDate);
            cal.add(Calendar.MONTH, Integer.parseInt(add));

            bDate = cal.getTime();

            if (aDate.compareTo(bDate) < 0) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
