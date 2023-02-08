package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testSize = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < testSize; test_case++) {
            int N = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String mode = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                int numCount = -1;
                
                if (mode.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) continue;
                    num = num == -1 ? treeMap.firstKey() : treeMap.lastKey();
                    numCount = treeMap.getOrDefault(num, -1);
                    if (numCount > 0) {
                        if (numCount == 1) {
                            treeMap.remove(num);
                        } else {
                            treeMap.put(num, treeMap.getOrDefault(num, 0) - 1);
                        }
                    }
                    // numCount = treeMap.put(num, treeMap.get(num) - 1);
                    // if (numCount == 1) {
                    //     treeMap.remove(num);

                    // }
                }

                // sb.append(treeMap.keySet() + " : ; ;" + treeMap.entrySet() + "  ' df").append("\n");
            } 

            sb.append(treeMap.isEmpty() ? "EMPTY" : (treeMap.lastKey() + " " + treeMap.firstKey()));
            if (test_case != testSize - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}
