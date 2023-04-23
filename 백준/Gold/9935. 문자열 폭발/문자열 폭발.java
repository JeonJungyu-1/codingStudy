import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 문자열 폭발

public class Main {
    
    static String S;
    static Character[] bomb;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(sb.toString().equals("") ? "FRULA" : sb.toString());
    }

    private static void solve() throws IOException {
        init();


        Stack<Character> stack = new Stack<>();
        Stack<Character> move = new Stack<>();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == bomb[index]) {
                stack.push(bomb[index]);
                if (index == bomb.length - 1) {
                    for (int j = 0; j < bomb.length; j++) {
                        stack.pop();
                    }
                    
                    if (!stack.isEmpty()) {
                        index = Arrays.asList(bomb).indexOf(stack.peek()) + 1;
                    } else {
                        index = 0;
                    }
                } else {
                    index++;
                }
            } else {
                if (S.charAt(i) == bomb[0]) {
                    stack.push(bomb[0]);
                    index = 1;
                } else {
                    stack.push(S.charAt(i));
                    while (!stack.isEmpty()) move.push(stack.pop());
                    while (!move.isEmpty()) sb.append(move.pop());
                    index = 0;
                }

                
            }
        }

        while (!stack.isEmpty()) move.push(stack.pop());
                    while (!move.isEmpty()) sb.append(move.pop());
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        S = br.readLine();
        char[] ch = br.readLine().toCharArray();
        bomb = new Character[ch.length];
        for (int i = 0; i < ch.length; i++) {
            bomb[i] = Character.valueOf(ch[i]);
        }
        

    }
}