import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Football Scoring

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

        int[] score = new int[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] += Integer.parseInt(st.nextToken()) * 6;
            score[i] += Integer.parseInt(st.nextToken()) * 3;
            score[i] += Integer.parseInt(st.nextToken()) * 2;
            score[i] += Integer.parseInt(st.nextToken()) * 1;
            score[i] += Integer.parseInt(st.nextToken()) * 2;
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}