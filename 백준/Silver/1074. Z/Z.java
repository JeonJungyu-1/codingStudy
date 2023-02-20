import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int count;
    static int N;
    static int R, C;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
    }

    private static void solve() {
        divide(0, 0, N);
    }

    private static void divide(int r, int c, int size) {

        if (r == R && c == C) {
            System.out.println(count);
            return;
        }
            
        if (r <= R && r + size > R && c <= C && c + size > C) {
            int half = size/2;
            divide(r, c, half);
            divide(r, c + half, half);
            divide(r + half, c, half);
            divide(r + half, c + half, half);
        } else {
            count += size * size;
        }
        
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = 1 << N;
    }
}