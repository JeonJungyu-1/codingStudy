
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int min;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // while (st.hasMoreTokens()) {
        //     st.nextToken();
        // }

        for (int i = 0; i < num; i++) {
            min = 0;
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            map = new int[row][column];
            
            for (int m = 0; m < map.length; m++) {
                Arrays.fill(map[m], 0);
            }

            int count = Integer.parseInt(st.nextToken());
            // 초기 배추 설정
            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            // 배추 탐색
            for (int k = 0; k < map.length; k++) {
                for (int l = 0; l < map[k].length; l++) {
                    if (map[k][l] == 1) {
                        checkAround(k, l);

                        
                         min++;
                    }
                }
            }
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    //탐색하고 -1로 바꾸면 상관 없을듯
    static void checkAround(int r, int c) {
        map[r][c] = -1;
        for (int i = 0; i < 4; i++) {
            if (!checkIndex(r + dx[i], c + dy[i]) && map[r + dx[i]][c + dy[i]] == 1) {
                checkAround(r + dx[i], c + dy[i]);
            }
        }
    }

    static boolean checkIndex(int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[0].length;
    }
}
