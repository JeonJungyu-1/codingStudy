import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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


        while (true) {
            String number = br.readLine();
            if (number.equals("0")) break;

            char[] ch = number.toCharArray();
            int result = 2 + ch.length - 1;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '0') {
                    result += 4;
                } else if (ch[i] == '1') {
                    result += 2;
                } else {
                    result += 3;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}