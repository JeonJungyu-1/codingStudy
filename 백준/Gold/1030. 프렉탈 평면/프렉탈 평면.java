import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 프렉탈 평면
// 분핧정복


public class Main {
    static StringBuilder sb;
    static int s, N, K, Rstart, Rend, Cstart, Cend;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        // for (int i = Rstart; i <= Rend; i++) {
        //     for (int j = Cstart; j <= Cend; j++) {
        //         if (map[i][j] == 0) {
        //             sb.append(1);
        //         } else {
        //             sb.append(0);
        //         }
        //     }
        //     sb.append("\n");
        // }
        System.out.println(sb.toString());
    }

    private static void solve() {
        // 1번 풀이 - 메모리초과
        // int length = (int)Math.pow(N, s);
        // map = new int[length][length];
        // divide(0, 0, (N - K)/2, length);
        
        
        // 2번 풀이 - 배열 만들지 말고 범위 안에 있는지만 확인하기
        int length = (int)Math.pow(N, s);
        for (int i = Rstart; i <= Rend; i++) {
            for (int j = Cstart; j <= Cend; j++) {
                sb.append(find(i, j, length));
            }
            sb.append("\n");
        }
    }

    private static int find(int r, int c, int length) {
        if (length == 1) {
            return 0;
        }
        int newLength = length / N;
        int start = (N - K) / 2 * newLength;
        if (r >= start && r < length - start && c >= start && c < length - start) {
            return 1;
        }

        return find(r % newLength, c % newLength, newLength);
    }

    private static void divide(int r, int c, int mid, int length) {
        if (length == N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i >= mid && i < mid + K && j >= mid && j < mid + K) continue;
                    map[r + i][c + j] = 1;
                }
            }
        } else {
            int newLength = length / N;
            for (int i = r; i < r + length; i += newLength) {
                for (int j = c; j < c + length; j += newLength) {
                    if (i >= r + mid * newLength && i < r + (K + mid) * newLength && j >= c + mid * newLength && j < c + (K + mid) * newLength) continue;
                    divide(i, j, mid, newLength);
                }
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Rstart = Integer.parseInt(st.nextToken());
        Rend = Integer.parseInt(st.nextToken());
        Cstart = Integer.parseInt(st.nextToken());
        Cend = Integer.parseInt(st.nextToken());
    }
}