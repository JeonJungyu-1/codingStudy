import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Laptop Sticker

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


        st = new StringTokenizer(br.readLine());
        int w1 = Integer.parseInt(st.nextToken());
        int h1 = Integer.parseInt(st.nextToken());
        int w2 = Integer.parseInt(st.nextToken());
        int h2 = Integer.parseInt(st.nextToken());

        if (w1 >= w2 + 2 && h1 >= h2 + 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}