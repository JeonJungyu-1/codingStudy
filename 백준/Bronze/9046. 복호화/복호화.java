import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 복호화

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
            char[] ch = br.readLine().toCharArray();
            
            int[] cnt = new int[26];

            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == ' ') continue;
                cnt[ch[i] - 97]++;
            }

            int max = Integer.MIN_VALUE;
            Queue<Character> que = new ArrayDeque<>();
            for (int i = 0; i < 26; i++) {

                if (cnt[i] > max) {
                    que.clear();
                    que.offer((char)(i + 97));
                    max = cnt[i];
                } else if (cnt[i] == max) {
                    que.offer((char)(i + 97));
                }
            }


            if (que.size() >= 2) {
                sb.append("?");
            } else {
                sb.append(que.poll());
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}