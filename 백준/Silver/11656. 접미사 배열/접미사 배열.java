import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 접미사 배열

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        String str = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb.toString());
        

    }
}