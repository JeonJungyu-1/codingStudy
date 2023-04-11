import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 수열

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();
        int index = 0;
        int number = 1;
        
        do {
            if (number <= N) {
                stack.push(number);
                sb.append("+").append("\n");
            }

            while (!stack.isEmpty() && stack.peek() == numbers[index]) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
            }
            number++;

        } while (index < N && number <= N);

        System.out.println(index < N ? "NO" : sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        stack = new Stack<>();
    }
}