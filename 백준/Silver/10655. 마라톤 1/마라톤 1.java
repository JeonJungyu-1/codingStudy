import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마라톤 1

public class Main {
    
    static StringBuilder sb;
    static int N;
    static Node[] list;
    static int minLength;
    static boolean[] visited;
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minLength);
    }

    private static void solve() {
        minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += calDistance(list[i], list[i + 1]);
        }

        for (int i = 1; i < N - 1; i++) {
            minLength = Math.min(minLength, sum - calDistance(list[i - 1], list[i]) - calDistance(list[i], list[i + 1]) + calDistance(list[i - 1], list[i + 1]));
        }
        
    }

    private static void perm(int cnt, int sum, int before) {
        if (sum >= minLength) return;
        if (cnt == N - 2) {
            minLength = Math.min(minLength, sum + calDistance(list[before], list[N - 1]));
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(cnt + 1, sum + calDistance(list[i], list[before]), i);
            visited[i] = false;
        }
    }

    private static int calDistance(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new Node[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new Node(r, c);
        }
    }
}