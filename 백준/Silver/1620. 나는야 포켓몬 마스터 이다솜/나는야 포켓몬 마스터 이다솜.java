import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int dicSize = Integer.parseInt(st.nextToken());
        int questionSize = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= dicSize; i++) {
            String poketmon = br.readLine();
            map.put(Integer.toString(i), poketmon);
            map.put(poketmon, Integer.toString(i));
        }

        for (int i = 0; i < questionSize; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb.toString());
    }

    
}
