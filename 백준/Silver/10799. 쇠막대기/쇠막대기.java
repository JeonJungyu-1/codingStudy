import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 쇠막대기

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
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                if (i + 1 < ch.length && ch[i + 1] == ')') {
                    i++;
                    cnt += stack.size();
                } else {
                    stack.push(ch[i]);
                }
            } else {
                stack.pop();
                cnt++;
            }

        }
        

        System.out.println(cnt);

    }
}