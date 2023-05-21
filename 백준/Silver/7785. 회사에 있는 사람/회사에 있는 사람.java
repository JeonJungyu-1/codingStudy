import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 회사에 있는 사람

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
        Map<String, Boolean> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String enterLeave = st.nextToken();

            if (enterLeave.equals("enter")) {
                map.put(name, true);
            } else {
                map.remove(name);
            }
        }

        for (String name : map.keySet()) {
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());

    }
}