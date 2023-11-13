import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 차량 번호판 1

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
        StringTokenizer st;
        sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();

        int d = 10;
        int c = 26;
        int result = 1;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'c') {
                result *= c;
                c = 25;
                if (i != ch.length - 1 && ch[i] != ch[i + 1]) {
                    c = 26;
                }
            } else {
                result *= d;
                d = 9;
                if (i != ch.length - 1 && ch[i] != ch[i + 1]) {
                    d = 10;
                }
            }
        }



        System.out.println(result);

    }
}