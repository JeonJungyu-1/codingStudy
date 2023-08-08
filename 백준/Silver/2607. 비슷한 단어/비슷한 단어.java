import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//비슷한 단어

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[] first = br.readLine().toCharArray();
        int len = first.length;
        // Map<Character, Integer> firstMap = new TreeMap<>();
        // Map<Character, Integer> map = new TreeMap<>();
        // for (int i = 0; i < len; i++) {
        //     firstMap.put(first[i], firstMap.getOrDefault(first[i], 0) + 1);
        // }

        int result = 0;
        // for (int i = 0; i < N - 1; i++) {
        //     int aDiff = 0;
        //     int bDiff = 0;
        //     int cnt = 0;
        //     map.clear();
        //     char[] ch = br.readLine().toCharArray();
        //     for (int j = 0; j < ch.length; j++) {
        //         map.put(ch[j], map.getOrDefault(ch[j], 0) + 1);
        //     }

        //     for (char key : map.keySet()) {
        //         if (map.get(key) < firstMap.getOrDefault(key, 0)) {
        //             aDiff += firstMap.getOrDefault(key, 0) - map.get(key);
        //         } else if (map.get(key) > firstMap.getOrDefault(key, 0)) {
        //             bDiff += map.get(key) - firstMap.getOrDefault(key, 0);
        //         }
        //     }
           
        //     if (aDiff <= 1 && bDiff <= 1 && (Math.abs(len - ch.length) < 2)) {
        //         result++;
        //     }
        // }
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < N - 1; i++) {
            char[] ch = br.readLine().toCharArray();
            dq.clear();
            for (int j = 0; j < ch.length; j++) {
                dq.add(ch[j]);
            }
            int cnt = 0;
            for (int j = 0; j < first.length; j++) {
                if (dq.contains(first[j])) {
                    dq.remove(first[j]);
                } else {
                    cnt++;
                }
            }

            if (cnt < 2 && dq.size() < 2) {
                result++;
            }
        }

        System.out.println(result);


    }
}