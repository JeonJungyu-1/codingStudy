import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하얀 칸

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
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && ch[j] == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}