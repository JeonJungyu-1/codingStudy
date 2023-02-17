import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static Queue<Integer> que = new PriorityQueue<>((a, b) -> {
        if (Math.abs(a) > Math.abs(b)) {
            return 1;
        } else if (Math.abs(a) == Math.abs(b)) {
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    });
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(que.peek() == null ? 0 : que.poll()).append("\n");
            } else {
                que.add(num);
            }
        }
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

  
    

    
}
