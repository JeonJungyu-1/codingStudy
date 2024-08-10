import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자동완성

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


        boolean isD2 = false;
        String str = br.readLine();
        if (str.equals("n") || str.equals("N")) isD2 = true;

        System.out.println(isD2 ? "Naver D2" : "Naver Whale");



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}