import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 패션왕 신해빈

public class Main {
    
    static StringBuilder sb;
    static int T, N;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new HashMap<>();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            map.clear();
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int number : map.values()) {
                result *= (number + 1);
            }
            sb.append(result - 1).append("\n");
        }

        System.out.println(sb.toString());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}