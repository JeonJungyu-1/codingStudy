import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모음의 개수

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;
            
            char[] ch = str.toLowerCase().toCharArray();
            int cnt = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') cnt++;
            }

            sb.append(cnt).append("\n");


        }

        System.out.println(sb.toString());

 
    }
}