import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주몽

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[] numbers;
    static int count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(count);

    }

    private static void solve() throws IOException {
        init();
        combination(0, 0, 0);
        print();
    }

    private static void combination(int cnt, int start, int sum) {
        if (cnt == 2) {
            if (sum == M) count++;
            return;
        }

        for (int i = start; i < N; i++) {
            if (numbers[i] >= M) continue;
            combination(cnt + 1, i + 1, sum + numbers[i]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


    }
}