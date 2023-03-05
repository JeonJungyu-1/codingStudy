import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 뒤집기

public class Main {
    static StringBuilder sb;
    static String S;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(cnt);
    }

    private static void solve() {
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(0) == S.charAt(i) && S.charAt(i) != S.charAt(i + 1)) cnt++;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        S = br.readLine();
   
    }
}