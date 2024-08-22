import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2033년 밈 투표

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



        Map<String, Boolean> map = new HashMap<>();

        map.put("Never gonna give you up", true);
        map.put("Never gonna let you down", true);
        map.put("Never gonna run around and desert you", true);
        map.put("Never gonna make you cry", true);
        map.put("Never gonna say goodbye", true);
        map.put("Never gonna tell a lie and hurt you", true);
        map.put("Never gonna stop", true);


        int N = Integer.parseInt(br.readLine());

        boolean isSuccess = true;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!map.containsKey(str)) {
                isSuccess = false;
                break;
            }
        }

        System.out.println(isSuccess ? "No" : "Yes");
        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}