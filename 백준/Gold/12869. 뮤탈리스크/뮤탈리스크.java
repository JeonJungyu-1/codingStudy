import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 뮤탈리스크

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static int[] permNumbers;
    static boolean isSuccess;
    static boolean[][][] visited;
    static int min;

    static class Attack {
        int cnt;
        int[] hp;
        public Attack(int cnt, int[] hp) {
            this.cnt = cnt;
            this.hp = hp;
        }
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] hp = new int[N];
        numbers = new int[N];


        st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
            max = Math.max(hp[i], max);
        }

        visited = new boolean[max + 1][max + 1][max + 1];

        int num = 9;
        for (int i = 0; i < N; i++) {
            numbers[i] = num;
            num /= 3;
        }

        

        int result = 0;
        if (N != 3) {
            result = getMin(hp);
        } else {
            result = bfs(hp);
        }
        


        System.out.println(result);
    }

    private static int bfs(int[] hp) {
        Queue<Attack> que = new ArrayDeque<>();
        que.offer(new Attack(1, hp));
        while (!que.isEmpty()) {

            Attack cur = que.poll();
            if (visited[cur.hp[0]][cur.hp[1]][cur.hp[2]]) continue;
            visited[cur.hp[0]][cur.hp[1]][cur.hp[2]] = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    for (int k = 0; k < 3; k++) {
                        if (i == k || j == k) continue;
                        int[] newHp = Arrays.copyOf(cur.hp, 3);
                        
                        newHp[0] -= numbers[i];
                        newHp[1] -= numbers[j];
                        newHp[2] -= numbers[k];
                        if (newHp[0] < 0) newHp[0] = 0;
                        if (newHp[1] < 0) newHp[1] = 0;
                        if (newHp[2] < 0) newHp[2] = 0;

                        if (newHp[0] <= 0 && newHp[1] <= 0 && newHp[2] <= 0) return cur.cnt;
                        que.offer(new Attack(cur.cnt + 1, newHp));

                    }
                }
            }
        }

        return -1;



    }

    private static int getMin(int[] hp) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> temp = new ArrayDeque<>();
        for (int i = 0 ; i < N; i++) {
            pq.offer(hp[i]);
        }

        int cnt = 0;
        while (!pq.isEmpty()) {

            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int num = pq.poll();
                num -= numbers[i];
                if (num > 0) {
                    temp.offer(num);
                }
            }
            
            while (!temp.isEmpty()) {
                pq.offer(temp.poll());
            }

            cnt++;
        }

        return cnt;
    }

    
}