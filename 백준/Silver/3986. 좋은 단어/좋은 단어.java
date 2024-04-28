import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 좋은 단어

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
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            stack.clear();
            for (int j = 0; j < ch.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(ch[j]);
                } else {
                    if (stack.peek() == ch[j]) {
                        stack.pop();
                    } else {
                        stack.push(ch[j]);
                    }
                }
            }

            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}