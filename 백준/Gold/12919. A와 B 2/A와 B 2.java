import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// A와 B 2

public class Main {
    
    static StringBuilder sb;
    static String start;
    static String end;
    static boolean isSuccess;
    static Map<String, Boolean> map;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();


        start = br.readLine();
        end = br.readLine();
        isSuccess = false;
        map = new HashMap<>();
        // dfs(end.length(), start);
        dfs(start.length(), end);

        System.out.println(isSuccess ? 1 : 0);

    }


    private static void dfs(int len, String prev) {
        if (isSuccess) return;

        if (prev.equals(start)) {
            isSuccess = true;
            return;
        }
        
        if (prev.length() <= len) return;
        char[] ch = prev.toCharArray();

        if (ch[ch.length - 1] == 'A') {
            dfs(len, prev.substring(0, ch.length - 1));
        }
        
        if (ch[0] == 'B') {
            StringBuilder s = new StringBuilder();
            for (int i = ch.length - 1; i > 0; i--) {
                s.append(ch[i]);
            }
            dfs(len, s.toString());
        }

    }
    // private static void dfs(int len, String prev) {
    //     if (isSuccess) return;

    //     if (map.getOrDefault(prev, false)) return;
    //     map.put(prev, true);

    //     if (prev.length() > len) return;
    //     if (prev.equals(end)) {
    //         isSuccess = true;
    //         return;
    //     }

    //     dfs(len, prev + "A");
    //     StringBuilder s = new StringBuilder(prev + "B");
    //     dfs(len, s.reverse().toString());

    // }
}