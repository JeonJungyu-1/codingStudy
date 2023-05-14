import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 국회의원 선거

public class Main {
    
    static StringBuilder sb;
    static Queue<Integer> que;
    static int one;
    static int count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() throws IOException {
        init();
        while (!que.isEmpty()) {
            if (one > que.peek()) break;
            int number = que.poll();
            que.offer(number - 1);
            one++;
            count++;
        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        one = Integer.parseInt(br.readLine());
        que = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            que.offer(Integer.parseInt(br.readLine()));
        }


    }
}