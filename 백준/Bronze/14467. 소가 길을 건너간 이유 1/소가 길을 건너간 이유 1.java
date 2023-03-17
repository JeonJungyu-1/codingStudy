import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
        
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        int cnt = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    map.put(key, value);
                    cnt++;
                }
            } else {
                map.put(key, value);
            }
        }
        System.out.println(cnt);
    }
}