import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 농구 경기

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

        Map<Character, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str.charAt(0), map.getOrDefault(str.charAt(0), 0) + 1);
        }


        
        for (Character key : map.keySet()) {
            if (map.get(key) >= 5) sb.append(key); 
        }

        System.out.println(sb.length() == 0 ? "PREDAJA" : sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}