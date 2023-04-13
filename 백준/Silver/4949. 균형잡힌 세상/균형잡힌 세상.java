import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상

public class Main {
    static int N;
    static Stack<Character> stack;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();

        outer:
        while (true) {
            char[] ch = br.readLine().toCharArray();
            stack.clear();
            if (ch[0] == '.') break;
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '(') {
                    stack.push(ch[j]);
                } else if (ch[j] == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        sb.append("no").append("\n");
                        continue outer;
                    }

                } else if (ch[j] == '[') {
                    stack.push(ch[j]);
                } else if (ch[j] == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        sb.append("no").append("\n");
                        continue outer;
                    }
                }
            }
            if (stack.empty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }


        System.out.println(sb.toString());
    }
}