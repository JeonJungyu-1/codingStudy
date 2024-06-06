import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 웰컴 키트

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


        int N = Integer.parseInt(br.readLine());
        
        int[] t = new int[6];
        int totalT = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            totalT += t[i];
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int resultT = 0;
        for (int i = 0; i < 6; i++) {
            resultT += t[i] / T;
            if (t[i] % T != 0) resultT++;
        }

        sb.append(resultT).append("\n").append(totalT / P).append(" ").append(totalT % P);
        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}