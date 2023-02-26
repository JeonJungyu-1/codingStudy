import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크
// bfs

public class Main {
    static StringBuilder sb;
    static int F, S, G, U, D;
    static boolean[] isVisited;
    static int min;
    static class Floor {
        int floor;
        int count;
        public Floor(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
        @Override
        public String toString() {
            return "Floor [floor=" + floor + ", count=" + count + "]";
        }

        
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        if (min == -1) {
            sb.append("use the stairs");
        } else {
            sb.append(min);
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        bfs();
    }

    private static void bfs() {
        Queue<Floor> que = new ArrayDeque<>();
        que.offer(new Floor(S, 0));

        while (!que.isEmpty()) {
            Floor f = que.poll();

            if (f.floor == G) {
                min = f.count;
                break;
            } 

            if ((f.floor > G && (f.floor - D) >= 1) || (f.floor < G && (f.floor + U) > F)) {
                int newFloor = f.floor - D;
                if (newFloor > F || newFloor < 1 || isVisited[newFloor]) continue;
                isVisited[newFloor] = true;
                que.offer(new Floor(newFloor, f.count + 1));
            } else if ((f.floor < G && (f.floor + U) <= F) || (f.floor > G && (f.floor - D) < 1)) {
                int newFloor = f.floor + U;
                if (newFloor > F || newFloor < 1 || isVisited[newFloor]) continue;
                isVisited[newFloor] = true;
                que.offer(new Floor(newFloor, f.count + 1));
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        isVisited = new boolean[F + 1];
        min = -1;


    }
}