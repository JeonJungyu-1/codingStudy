import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// OX퀴즈

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            int totalScore = 0;
            char[] ch = br.readLine().toCharArray();
            int score = 1;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 'X') {
                    score = 1;
                } else {
                    totalScore += score;
                    score++;
                }
            }

            sb.append(totalScore).append("\n");
        }

        System.out.println(sb.toString());

    }
}