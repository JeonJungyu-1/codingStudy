import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 카드

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        Map<Long, Long> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        long number = 0;
        for (int i = 0; i < N; i++) {
            number = Long.parseLong(br.readLine());
            map.put(number, map.getOrDefault(number, 0l) + 1);
        }

        long result = 0;
        Long max = -1l;
        for (long num : map.keySet()) {
            if (max < map.get(num)) {
                max = Math.max(map.get(num), max);
                result = num;
            }
        }

        System.out.println(result);



    }
}