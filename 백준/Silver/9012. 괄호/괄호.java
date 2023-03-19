import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 괄호
// 스택

public class Main {
    static StringBuilder sb;
    static int N;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
    }

    private static void solve() {
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            stack.clear();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '(') {
                    stack.push(ch[j]);
                } else {
                    if (stack.empty()) {
                        stack.push(ch[j]);
                        break;
                    }
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            sb.append(stack.empty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());


    }
}