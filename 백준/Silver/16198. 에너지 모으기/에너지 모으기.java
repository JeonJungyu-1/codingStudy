import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에너지 모으기

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(max);
    }

    private static void solve() throws IOException {
        init();

        dfs(0, 0);

        print();
    }

    private static void dfs(int cnt, int sum) {
        if (cnt == N - 2) {
            max = Math.max(max, sum);
            return;
        }


        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) continue;
            int prev = getPrev(i);
            int next = getNext(i);

            visited[i] = true;
            dfs(cnt + 1, sum + (numbers[prev] * numbers[next]));
            visited[i] = false;
        }
        

    }

    private static int getNext(int num) {

        for (int i = num + 1; i < N; i++) {
            if (!visited[i]) return i;
        }
        return 0;
    }

    private static int getPrev(int num) {

        for (int i = num - 1; i >= 0; i--) {
            if (!visited[i]) return i;
        }

        return 0;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
  
    }
}