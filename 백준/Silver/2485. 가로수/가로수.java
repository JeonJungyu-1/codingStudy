import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 가로수

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] tree;
    static int max, result;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(result);
    }

    private static void solve() throws IOException {
        init();

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i < N; i++) {
            que.offer(tree[i] - tree[i - 1]);
        }
        
        Queue<Integer> newQue = new ArrayDeque<>(que);

        max = que.poll();

        while (!que.isEmpty()) {
            max = gcd(max, que.poll());
        }


        result = 0;
        while (!newQue.isEmpty()) {
            int cur = newQue.poll();
            result += (cur / max) - 1;
        }


        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }


    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}