import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 친구 - dfs???
public class Main {

    static int N;
    static int[][] map;
    static boolean[] isVisited;
    static int friend;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max = -1;

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] == 'Y' ? 1 : 0;
            }
        }

        // 모든 사람 차례대로 탐색
        for (int i = 0; i < N; i++) {
            friend = 0;
            isVisited = new boolean[N];
            isVisited[i] = true;
            explore(0, i);
            max = Math.max(max, friend);
        }

        System.out.println(max);

        br.close();
    }

    // dfs
    static void explore(int cnt, int from) {
        // 2 - 친구까지만 구하기
        if (cnt == 2) {
            return;
        }


        for (int i = 0; i < N; i++) {
            if (map[from][i] == 0 || (cnt != 0 && isVisited[i])) continue;
            if (cnt != 0 || !isVisited[i]) {
                friend++;
            }
            isVisited[i] = true;
            // System.out.printf("%d %d \n", from, i);
            explore(cnt + 1, i);
        }
    }
}



// 0 1
// 0 2
// 0 4
// 1 2
// 2 3
// 4 5
