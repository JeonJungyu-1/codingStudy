import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// 자료구조는 정말 최고야

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        List<Stack<Integer>> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        boolean isAvailable = true;
        outer:
        for (int i = 0; i < M; i++) {
            stack.clear();
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int k = 0 ; k < K ; k++) {
                int number = Integer.parseInt(st.nextToken());
                if (!stack.isEmpty() && stack.peek() < number) {
                    isAvailable = false;
                    break outer;
                }
                stack.push(number);
            }
        }

        System.out.println(isAvailable ? "Yes" : "No");



    }

}