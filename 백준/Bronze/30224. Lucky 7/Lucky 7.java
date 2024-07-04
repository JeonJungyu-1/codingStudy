import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Lucky7

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

        String str = br.readLine();
        char[] ch = str.toCharArray();

        boolean isContain = false;
        boolean isDivide = false;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '7') isContain = true;
        }
        if (Integer.parseInt(str) % 7 == 0) isDivide = true;

        
        if (!isContain) {
            if (!isDivide) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else {
            if (!isDivide) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }

        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}