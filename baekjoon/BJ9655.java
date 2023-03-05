package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 돌 게임

public class BJ9655 {
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
        if (N % 2 == 1) {
            sb.append("SK");
        } else {
            sb.append("CY");
        }

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
