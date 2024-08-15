import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// NFC West vs North

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

        System.out.println("NFC West       W   L  T\n" + //
                        "-----------------------\n" + //
                        "Seattle        13  3  0\n" + //
                        "San Francisco  12  4  0\n" + //
                        "Arizona        10  6  0\n" + //
                        "St. Louis      7   9  0\n" + //
                        "\n" + //
                        "NFC North      W   L  T\n" + //
                        "-----------------------\n" + //
                        "Green Bay      8   7  1\n" + //
                        "Chicago        8   8  0\n" + //
                        "Detroit        7   9  0\n" + //
                        "Minnesota      5  10  1");




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}