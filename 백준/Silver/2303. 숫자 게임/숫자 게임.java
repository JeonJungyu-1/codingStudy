import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 게임
// 조합

public class Main {
    static StringBuilder sb;
    static int T;
    static int[] number;
    static int maxNumber;
    static int[] max;
    public static void main(String[] args) throws IOException {
       solve();

    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        number = new int[5];
        max = new int[2];
        max[0] = Integer.MIN_VALUE;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }
            maxNumber = Integer.MIN_VALUE;
            combination(0, 0, 0);

            if (maxNumber > max[0]) {
                max[0] = maxNumber;
                max[1] = t;
            } else if (maxNumber == max[0]) {
                max[1] = t;
            }
        }

        System.out.println(max[1]);


    }



    private static void combination(int cnt, int start, int sum) {
        if (cnt == 3) {
            maxNumber = Math.max(maxNumber, sum);
            return;
        }

        for (int i = start; i < 5; i++) {
            combination(cnt + 1, i + 1, (sum + number[i]) % 10);
        }
    }
}