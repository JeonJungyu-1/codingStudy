import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] height;


    static class Top {
        int index, height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int[] result) {
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();

        int[] result = new int[N];
        // 6 9 5 7 4
        // 6 6 5 7 4

        Stack<Top> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(new Top(i, height[i]));
            } else {
                
                while (!stack.isEmpty() && stack.peek().height < height[i]) {
                    Top cur = stack.pop();
                    result[cur.index] = i + 1;
                }
                
                stack.push(new Top(i, height[i]));
                
            }
        }

        print(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}