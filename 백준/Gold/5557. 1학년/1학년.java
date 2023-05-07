import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1학년
// dp

public class Main {
    
    static StringBuilder sb;
    static int n;
    static int[] number;
    static int lastNumber;
    static long count;
    static long[][] memo;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(memo[n - 2][lastNumber]);
    }

    private static void solve() throws IOException {
        init();
        memo[0][number[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (j + number[i] <= 20) {
                    memo[i][j + number[i]] += memo[i - 1][j];
                }

                if (j - number[i] >= 0) {
                    memo[i][j - number[i]] += memo[i - 1][j];
                }
            }
        }

        print();
    }



    private static int calculateNewSum(int cnt) {
        int result = 0;
        for (int i = cnt; i < n - 1; i++) {
            result += number[i];
        }
        return result;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        
        lastNumber = Integer.parseInt(st.nextToken());
        memo = new long[n - 1][21];

    }
}