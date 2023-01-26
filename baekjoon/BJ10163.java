package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BJ10163 {
    static int[][] map = new int[1001][1001];
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> hashmap = new HashMap<>();
        // 맵 초기화
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        
        // 색종이 위치하고 크기 받아서 맵에 번호 넣어주기
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int width = Integer.parseInt(input[2]);
            int height = Integer.parseInt(input[3]);

            for (int j = r; j < r + width; j++) {
                for (int k = c; k < c + height; k++) {
                    map[j][k] = i + 1;
                }
            }
        }

        // 맵 돌면서 번호 개수 세기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0) {
                    if (!hashmap.containsKey(map[i][j])) {
                        hashmap.put(map[i][j], 1);
                    } else {
                        hashmap.put(map[i][j], hashmap.get(map[i][j]) + 1);
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // for (Map.Entry<Integer, Integer> entry: hashmap.entrySet()) {
        //     sb.append(entry.getValue()).append("\n");
        // }

        // 출력
        for (int i = 0; i < num; i++) {
            if (hashmap.get(i + 1) == null) {
                hashmap.put(i + 1, 0);
            }
            sb.append(hashmap.get(i + 1)).append("\n");
        }

        System.out.println(sb);
    }
}
