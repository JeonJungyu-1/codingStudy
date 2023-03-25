import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카잉 달력
// 브루트포스
// 최소공배수 구할 때 유클리드 호제법을 이용

public class Main {
    
    static StringBuilder sb;
    static int T, M, N, x, y;
    public static void main(String[] args) throws IOException {
        solve();

    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int currentX = x;
            int lcm = lcm(M, N);
            while (true) {
                if ((currentX - 1) % N + 1 == y || currentX > lcm) {
                    break;
                }

                currentX += M;
            }
            sb.append(currentX > lcm ? -1 : currentX).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd2(a, b);
    }
}