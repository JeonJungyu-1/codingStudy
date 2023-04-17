import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR

public class Main {
    
    static StringBuilder sb;
    static int T;
    static int start, end;
    static boolean[] visited;

    static class Number {
        int num;
        String command;
        public Number(int num, String command) {
            this.num = num;
            this.command = command;
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
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        visited = new boolean[10001];

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            
            Arrays.fill(visited, false);
            bfs();
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static void bfs() {
        Queue<Number> que = new ArrayDeque<>();
        que.offer(new Number(start, ""));
        
        int mulNum = 1000;
        while (!que.isEmpty()) {
            Number cur = que.poll();
            if (visited[cur.num]) continue;
            visited[cur.num] = true;
            if (cur.num == end) {
                sb.append(cur.command).append("\n");
                break;
            }

            que.offer(new Number(cur.num * 2 % 10000, cur.command + "D"));
            que.offer(new Number(cur.num == 0 ? 9999 : cur.num - 1, cur.command + "S"));
            // int len = String.valueOf(cur.num).length();
            // int mulNum = (int)Math.pow(10, len - 1);

            que.offer(new Number(cur.num % mulNum * 10 + cur.num / mulNum, cur.command + "L"));

            que.offer(new Number(cur.num / 10 + cur.num % 10 * mulNum, cur.command + "R"));


        }
    }
}