import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 디지털 티비

public class Main {
    
    static StringBuilder sb;
    static String[] channel;
    static int first, second;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();

        
        for (int i = 0; i < first; i++) {
            sb.append("1");
        }
        for (int i = 0; i < first; i++) {
            sb.append("4");
        }

        for (int i = 0; i < second; i++) {
            sb.append("1");
        }

        if (second < first) {
            sb.append("1");
        }

        for (int i = 0; i < second - 1; i++) {
            sb.append("4");
        }

        if (second < first) {
            sb.append("4");
        }

        System.out.println(sb.toString());



        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        channel = new String[N];

        for (int i = 0; i < N; i++) {
            channel[i] = br.readLine();
            if (channel[i].equals("KBS1")) {
                first = i;
            } else if (channel[i].equals("KBS2")) {
                second = i;
            }
        }
    }
}