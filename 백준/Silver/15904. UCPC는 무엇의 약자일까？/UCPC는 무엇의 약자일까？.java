import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// UCPC는 무엇의 약자일까?

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        char[] ch = br.readLine().toCharArray();
        char[] character = new char[]{'U', 'C', 'P', 'C'};
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (cnt < 4 && ch[i] == character[cnt]) {
                cnt++;
                if (cnt == 4) break;
            }
        }


        System.out.println(cnt == 4 ? "I love UCPC" : "I hate UCPC");




    }
}