import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 사탕 게임
// 브루트포스

public class Main {
    static int N;
    static char[][] map;
    static int max;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        System.out.println(max);
    }

    private static void solve() {
        max = Integer.MIN_VALUE;
        // 교환하지 않았을 때 개수 구하기
        for (int i = 0; i < N; i++) {
            countColumn(i);
            if (max == N) return;
        }

        for (int j = 0; j < N; j++) {
            countRow(j);
            if (max == N) return;
        }


        // 가로 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] != map[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    countRow(j);
                    countColumn(i);
                    countRow(j + 1);
                    swap(i, j, i, j + 1);
                    if (max == N) return;
                }
            }
        }

        // 세로 교환
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] != map[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    countColumn(i);
                    countRow(j);
                    countColumn(i + 1);
                    swap(i, j, i + 1, j);
                    if (max == N) return;
                }
            }
        }
    }

    private static void countRow(int j) {
        int cnt = 1;
        for (int i = 0; i < N - 1; i++) {
            if (map[i][j] == map[i + 1][j]) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);

    }


    private static void countColumn(int i) {
        int cnt = 1;
        for (int j = 0; j < N - 1; j++) {
            if (map[i][j] == map[i][j + 1]) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);

    }

    private static void swap(int i, int j, int i2, int j2) {
        char temp = map[i][j];
        map[i][j] = map[i2][j2];
        map[i2][j2] = temp;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}