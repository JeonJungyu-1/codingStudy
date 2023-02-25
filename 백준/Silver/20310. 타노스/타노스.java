import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 타노스
// 문자열 메소드 연습

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        String[] strArr = br.readLine().split("");
        Arrays.sort(strArr);
        String str = String.join("", strArr);
        str = str.replaceAll("00", "0");
        str = str.replaceAll("11", "1");
        System.out.println(str);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}