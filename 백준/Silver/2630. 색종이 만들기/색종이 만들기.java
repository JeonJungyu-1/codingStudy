import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] map;
    static boolean isSame;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        explore(0, 0, N);

        System.out.println(white);
        System.out.println(blue);


    }

    static void explore(int r, int c, int width) {
        // 1 X 1이거나 같은색으로 이루어져 있을 때 끝내기
        if (width == 1 || isSame(r, c, width) == true) {
            int lastNum = map[r][c];
            if (lastNum == 1) {
                blue++;
            } else {
                white++;
            }   
            return;
        }

        explore(r, c, width/2);
        explore(r, c + width/2, width/2);
        explore(r + width/2, c, width/2);
        explore(r + width/2, c + width/2, width/2);
        
    }

    static boolean isSame(int r, int c, int width) {
        int lastNum = map[r][c];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (lastNum != map[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
