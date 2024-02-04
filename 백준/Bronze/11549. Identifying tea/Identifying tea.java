import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Identifying tea

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

        int tea = Integer.parseInt(br.readLine());

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number == tea) result++;
        }

        System.out.println(result);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}