import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 폴리오미노

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
        Stack<Character> stack = new Stack<>();

        

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'X') {
                stack.push(ch[i]);
            } else if (ch[i] == '.') {
                if (stack.size() != 4 && stack.size() != 2 && stack.size() != 0) {
                    System.out.println(-1);
                    return;
                }
                sb.append(".");
            }

            if (stack.size() == 4) {
                sb.append("AAAA");
                stack.clear();
            } else if (stack.size() == 2 && (i == ch.length - 1 || i < ch.length && ch[i + 1] == '.')) {
                sb.append("BB");
                stack.clear();
            } 

        }


        if (stack.size() == 4) {
            sb.append("AAAA");
        } else if (stack.size() == 2) {
            sb.append("BB");
        } else if (!stack.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}