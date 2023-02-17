import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int count;
    static boolean isEnd;
    static int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dc = {-1, 0, 1, 1, -1, -1, 0, 1};
    static int direction;
    static int[] win;
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new int[21][21];
        win = new int[3];

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        a:
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (map[i][j] == map[i + dr[k]][j + dc[k]] && map[i + dr[7 - k]][j + dc[7 - k]] != map[i][j]) {
                            direction = k;
                            int nr = i + dr[direction];
                            int nc = j + dc[direction];
                            count = 1;
                            while (true) {
                                nr += dr[direction];
                                nc += dc[direction];
        
                                if (map[nr][nc] != map[i][j]) break;
                                
                                if (map[nr][nc] == map[i][j]) count++;
        
                            }
                            
                           
                            if (count > 4) continue;
                            if (count == 4) {
                                win[0] = map[i][j];
                                win[1] = direction != 0 ? i : nr - dr[direction];
                                win[2] = direction != 0 ? j : nc - dc[direction];
                                // if (direction == 0) {
                                //     win[1] = nr - dr[direction];
                                //     win[2] = nc - dc[direction];
                                // } else {
                                //     win[1] = i;
                                //     win[2] = j;
                                // }
                            
                                break a;
                            }
                            
                        }
                    }

                }
            }
        }
        sb.append(win[0]).append("\n");
        if (win[0] != 0) {
            sb.append(win[1]).append(" ").append(win[2]);
        }

        System.out.println(sb.toString());

    }


}
