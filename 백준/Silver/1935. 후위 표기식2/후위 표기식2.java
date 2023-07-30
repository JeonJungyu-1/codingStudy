import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// 후위 표기식2

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
        Map<Character, Double> map = new HashMap<>();

        char[] ch = br.readLine().toCharArray();
        
        char eng = 65;
        for (int i = 0; i < N; i++) {
            map.put(eng, Double.parseDouble(br.readLine()));
            eng++;
        }


        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] < 65 || ch[i] > 97) {
                double b = stack.pop();
                double a = stack.pop();
                switch (ch[i]) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                
                }

            } else {
                stack.push(map.get(ch[i]));
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}