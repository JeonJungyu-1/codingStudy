import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 마인크래프트

public class Main {
    static int N, M, B;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map.put(number, map.getOrDefault(number, 0) + 1);
                min = Math.min(min, number);
                max = Math.max(max, number);
            }
        }

        StringBuilder sb = new StringBuilder();
        int minTime = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        // System.out.println(map.keySet());
        for (int i = max; i >= min; i--) {
            int cnt = map.getOrDefault(i, 0);
            int time = 0;
            int block = B;
            for (int key : map.keySet()) {
                if (key > i) {
                    // cnt += map.get(key);
                    cnt += map.get(key);
                    time += ((key - i) * map.get(key) * 2);
                    block += (key - i) * map.get(key);
                }
            }

            // System.out.println(cnt);
            // System.out.println(time);
            // System.out.println(block);
            // System.out.println();

            for (int key : map.keySet()) {
                if (key < i && block > 0) {
                    
                    if (block >= (i - key) * map.get(key)) {
                        cnt += map.get(key);

                        time += (i - key) * map.get(key);
                        block -= (i - key) * map.get(key);
                    } else {
                        // cnt += map.get(key);

                        // time += block;
                        // block = 0;
                        break;
                    }
                }
            }

            // System.out.println(cnt);
            // System.out.println(time);
            // System.out.println(block);
            // System.out.println();

            // System.out.println(cnt + "dfjkdf");
            
            if (cnt == N * M && minTime >= time ) {
                if ((high < i && minTime == time) || minTime > time) {
                    high = i;
                }
                minTime = time;
            }
            // System.out.println(i);
            // System.out.println(minTime);
            // System.out.println(high);
            // System.out.println();
        }
        sb.append(minTime).append(" ").append(high);
        System.out.println(sb.toString());
        
    }
}