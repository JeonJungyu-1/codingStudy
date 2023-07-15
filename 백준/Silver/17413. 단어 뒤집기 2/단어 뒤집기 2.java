import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 단어 뒤집기 2

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
        StringTokenizer st;
        sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            
            if (!stack.isEmpty() && stack.peek() == '<') {
                if (ch[i] == '>') stack.pop();
                sb.append(ch[i]);

            } else {
                if (ch[i] != ' ') stack.push(ch[i]);
                if ((!stack.isEmpty() && stack.peek() == '<') || ch[i] == ' ') sb.append(ch[i]);
                
                

                if (!stack.isEmpty() && stack.peek() != '<' && i < ch.length - 1 && (ch[i + 1] == ' ' || ch[i + 1] == '<')) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.toString());

    }
}