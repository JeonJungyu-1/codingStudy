import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 크로아티아 알파벳

public class Main {
    
    static StringBuilder sb;
    static String str;
    static String[] replaceStr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        solve();
    }
  

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        str = br.readLine();
        for (String rep : replaceStr) {
            str = str.replace(rep, "1");
        }

        System.out.println(str.length());   
    }
}