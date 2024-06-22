import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 정보보호학부 동아리

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

        Map<String, String> map = new HashMap<>();

        map.put("M", "MatKor");
        map.put("W", "WiCys");
        map.put("C", "CyKor");
        map.put("A", "AlKor");
        map.put("$", "$clear");

        System.out.println(map.get(br.readLine()));



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}