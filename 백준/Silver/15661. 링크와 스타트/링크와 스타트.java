import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 링크와 스타트

public class Main {
    
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static boolean[] numbers;
    static int min;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(min);
    }

    private static void solve() throws IOException {
        init();
        subset(0);
        print();
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            
            int aSum = caculateSum(true);
            int bSum = caculateSum(false);

            min = Math.min(Math.abs(aSum - bSum), min);
            return;
        }


        numbers[cnt] = true;
        subset(cnt + 1);
        numbers[cnt] = false;
        subset(cnt + 1);
    }

    private static int caculateSum(boolean isTrue) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] == isTrue) continue;
            for (int j = i + 1; j < N; j++) {
                if (numbers[j] == isTrue) continue;
                sum += map[i][j];
                sum += map[j][i];
            }
        }
        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        numbers = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
    }
}