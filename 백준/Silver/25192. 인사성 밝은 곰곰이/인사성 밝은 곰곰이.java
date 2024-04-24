import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 인사성 밝은 곰곰이

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                map.clear();
            } else {
                if (!map.getOrDefault(str, false)) {
                    map.put(str, true);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}