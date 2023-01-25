package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ10828 {
    static List<Integer> stack = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();

            if (str.contains("push")) {
                push(Integer.parseInt(str.split(" ")[1]));
            } else if (str.equals("pop")) {
                pop();
            } else if (str.equals("size")) {
                size();
            } else if (str.equals("empty")) {
                empty();
            } else if (str.equals("top")) {
                top();
            }
        }

        System.out.println(sb);
    }

    static void push(int num) {
        stack.add(num);
    }

    static void pop() {
        if (stack.size() <= 0) {
            sb.append("-1").append("\n");
        } else {
            sb.append(stack.get(stack.size() - 1)).append("\n");
            stack.remove(stack.size() - 1);
        }
    }

    static void size() {
        sb.append(stack.size()).append("\n");
    }

    static void empty() {
        if (stack.size() <= 0) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    static void top() {
        if (stack.size() <= 0) {
            sb.append("-1").append("\n");
        } else {
            sb.append(stack.get(stack.size() - 1)).append("\n");
        }
    }
}
