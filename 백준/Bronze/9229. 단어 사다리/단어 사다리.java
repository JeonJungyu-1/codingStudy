import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 단어 사다리

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

        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;

            Queue<String> que = new ArrayDeque<>();
            que.offer(s);
            while (true) {
                String str = br.readLine();
                if (str.equals("#")) break;
                que.offer(str);
            }

            boolean isSuccess = true;
            String one = que.poll();
            while (!que.isEmpty()) {
                String two = que.poll();
                if (!check(one, two)) {
                    isSuccess = false;
                    break;
                }
                one = two;
            }

            sb.append(isSuccess ? "Correct" : "Incorrect").append("\n");


        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static boolean check(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        if (a.length != b.length) return false;

        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) cnt++;
        }

        return cnt == 1 ? true : false;

    }
}