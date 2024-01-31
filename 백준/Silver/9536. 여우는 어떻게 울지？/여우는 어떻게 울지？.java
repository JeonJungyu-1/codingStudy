import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 여우는 어떻게 울지?

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

        int T = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new HashMap<>();
        for (int t = 0; t < T; t++) {
            String[] fox = br.readLine().split(" ");
            
            while (true) {
                String str = br.readLine();
                if (str.equals("what does the fox say?")) break;
                map.put(str.split(" ")[2], false);
            }

            for (int i = 0; i < fox.length; i++) {
                if (map.getOrDefault(fox[i], true)) {
                    sb.append(fox[i]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}