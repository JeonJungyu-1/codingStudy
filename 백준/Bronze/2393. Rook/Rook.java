import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Rook

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
        System.out.println("  ___  ___  ___\n" + //
                        "  | |__| |__| |\n" + //
                        "  |           |\n" + //
                        "   \\_________/\n" + //
                        "    \\_______/\n" + //
                        "     |     |\n" + //
                        "     |     |\n" + //
                        "     |     |\n" + //
                        "     |     |\n" + //
                        "     |_____|\n" + //
                        "  __/       \\__\n" + //
                        " /             \\\n" + //
                        "/_______________\\");




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}