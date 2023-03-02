import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> list;
    static List<Integer> sortedList;
    static Map<Integer, Integer> map;
    static Set<Integer> set;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
    }

    private static void solve() {
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            int num = sortedList.get(i);
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb.toString());

    }

    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            list.add(num);
        }

        sortedList = new ArrayList<>(set);
        map = new HashMap<>();
    }
}