import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
  

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int[][] map = new int[101][101];

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int i = r; i < r + 10; i++) {
                for (int j = c; j < c + 10; j++) {
                    map[i][j]++;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) result++;
            }
        }


        System.out.println(result);

    }
}