import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ISBN

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

        int sum = 91;
        sum += Integer.parseInt(br.readLine()) * 1;
        sum += Integer.parseInt(br.readLine()) * 3;
        sum += Integer.parseInt(br.readLine()) * 1;

        System.out.println("The 1-3-sum is " + sum);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}