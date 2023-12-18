import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5의 수난

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

        char[] ch = br.readLine().toCharArray();
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += pow(ch[i] - '0', 5);
        }


        System.out.println(result);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }


    private static int pow(int number, int p) {
        int result = 1;

        for (int i = 0; i < p; i++) {
            result *= number;
        }

        return result;
    }
}