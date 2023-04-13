import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static Stack<Integer> stack;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}