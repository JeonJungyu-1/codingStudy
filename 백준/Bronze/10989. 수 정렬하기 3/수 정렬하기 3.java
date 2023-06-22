import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 수 정렬하기 3
// 정렬

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
        // Map<Integer, Integer> map = new TreeMap<>();
        int[] list = new int[10001];
        int number = 0;
        for (int i = 0; i < N; i++) {
            number = Integer.parseInt(br.readLine());
            list[number]++;
            // map.put(number, map.getOrDefault(number, 0) + 1);
        }

        

        // for (int key : map.keySet()) {
            
        //     for (int i = 0; i < map.get(key); i++) {
        //         sb.append(key).append("\n");
        //     }

        // }

        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0) continue;
            for (int j = 0; j < list[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}