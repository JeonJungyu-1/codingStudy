
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> strSet = new HashSet<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            strSet.add(br.readLine());
        }

        List<String> strList = new ArrayList<>(strSet);

        strList.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
            
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            sb.append(strList.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
