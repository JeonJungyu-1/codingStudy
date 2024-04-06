import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오셀로 재배치

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

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            char[] A = br.readLine().toCharArray();
            char[] B = br.readLine().toCharArray();

            int aCount = 0;
            int bCount = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] == B[i]) continue;

                if (A[i] == 'B' && B[i] == 'W') {
                    aCount++;
                } else {
                    bCount++;
                }
            }   

            sb.append(Math.max(aCount, bCount)).append("\n");


        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}