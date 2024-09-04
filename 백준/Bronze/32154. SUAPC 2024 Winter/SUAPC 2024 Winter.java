import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SUAPC 2024 Winter

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

        String[] score = new String[10];
        score[0] = "A B C D E F G H J L M";
        score[1] = "A C E F G H I L M";
        score[2] = "A C E F G H I L M";
        score[3] = "A B C E F G H L M";
        score[4] = "A C E F G H L M";
        score[5] = "A C E F G H L M";
        score[6] = "A C E F G H L M";
        score[7] = "A C E F G H L M";
        score[8] = "A C E F G H L M";
        score[9] = "A B C F G H L M";

        int N = Integer.parseInt(br.readLine());
        String result = score[N - 1];
        System.out.println((result.toCharArray().length + 1) / 2);
        System.out.println(result);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}