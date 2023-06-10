import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 대칭 차집합

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        Map<Integer, Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }

        int intersection = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            if (map.containsKey(Integer.parseInt(st.nextToken()))) intersection++;
        }

        int result = A + B - (2 * intersection);
        System.out.println(result);

    }
}