import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<String, Boolean> map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (map.containsKey(s)) {
                    map.remove(s);
                }
            }
            sb.append(map.size()).append("\n");
        }


    }
}