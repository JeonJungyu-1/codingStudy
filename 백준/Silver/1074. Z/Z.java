import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // static int[][] map;
    static int count = 0;
    static boolean isEnd = false;
    static int nr;
    static int nc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        nr = Integer.parseInt(st.nextToken());
        nc = Integer.parseInt(st.nextToken());
        // map = new int[2<<N][2<<N];
        // if (N == 1) {
            // count = 0;
        // } else {
            exploreMap(0, 0, 1 << N );
        // }
           
        System.out.println(count);
    }

    // static void exploreMap(int r, int c, int n) {
    //     if (n == 2) {
    //         for (int i = 0; i < 2; i++) {
    //             for (int j = 0; j < 2; j++) {
    //                 map[r + i][c + j] = count++;
    //             }
    //         }
    //     } else {
    //         for (int i = 0; i < 2; i++) {      
    //             for (int j = 0; j < 2; j++) {
    //                 exploreMap(r + i * n / 2, c + j * n / 2, n / 2);
    //             }
    //         }
    //     }
    // }3 7 7

    static void exploreMap(int r, int c, int n) {
        if (isEnd == true) return;
        // System.out.printf("r: %d c:%d n:%d count:%d :: %d %d \n", r, c, n, count, nr - r, nc - c);
        if (n == 1) {
            a:
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (nr == r + i && nc == c + j) {
                        isEnd = true;
                        break a;
                    } else {
                        count++;
                    }
                }
            }
        } else {
            a:
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    // if ((nr - i * n >= r + i || nr - i * n < 0) || (nc - j * n >= c + j || nc - j * n < 0)) {
                    if ((nr - r - i * n < n && nr - r - i * n >= 0) && (nc - c - j * n < n && nc - c - j * n >= 0) ) {
                        exploreMap(r + i * n, c + j * n, n / 2);
                        break a;
                    } else {
                        count += n * n;
                    }
                }
            }

        }
    }
}
