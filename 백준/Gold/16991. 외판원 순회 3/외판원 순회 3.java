import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 외판원 순회 3
// 비트 dp

public class Main {
    static int N;
    static double[][] dist, dp;
    static final double INF = Double.MAX_VALUE / 100.0;
    static Node[] list;
    static class Node {
        double r, c;
        int index;
        public Node(double r, double c, int index) {
            this.r = r;
            this.c = c;
            this.index = index;
        }

        
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }

    private static void solve() throws NumberFormatException, IOException {
        init();
        combination(0, 0, new Node[2]);

        double min = tps(1, 0);
        System.out.println(min);
    }

    

    private static double tps(int visited, int city) {

        if (visited == ((1 << N) - 1)) {
            return dist[city][0] == 0.0 ? INF : dist[city][0];
        }

        if (dp[visited][city] != -1) {
            return dp[visited][city];
        }

        dp[visited][city] = INF;
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) continue;

            if (dist[city][i] == 0) continue;

            double sum = tps(visited | (1 << i), i) + dist[city][i];
            dp[visited][city] = Math.min(sum, dp[visited][city]);
        }

        return dp[visited][city];
    }

    private static void combination(int cnt, int start, Node[] numbers) {
        if (cnt == 2) {
            double distance = calculateDistance(numbers[0].r, numbers[0].c, numbers[1].r, numbers[1].c);
            dist[numbers[0].index][numbers[1].index] = distance;
            dist[numbers[1].index][numbers[0].index] = distance;
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = list[i];
            combination(cnt + 1, i + 1, numbers);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new double[N][N];
        dp = new double[1 << N][N];
        list = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double s = Double.parseDouble(st.nextToken());
            double e = Double.parseDouble(st.nextToken());
            list[i] = new Node(s, e, i);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);        
        }
    }

    private static double calculateDistance(double xR, double xC, double yR, double yC) {
        double sum = Math.pow(xR - yR, 2) + Math.pow(xC - yC, 2);
        return Math.sqrt(sum); 
    }
}