import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 듣보잡

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.getOrDefault(name, 0) == 1) {
                map.put(name, 2);
                cnt++;
            }
        }


        sb.append(cnt).append("\n");
        for (String name : map.keySet()) {
            if (map.getOrDefault(name, 0) == 2) {
                sb.append(name).append("\n");
            }
        }

        System.out.println(sb.toString());

        




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}