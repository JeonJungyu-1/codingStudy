package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_2 {
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
        
        exploreMap(0, 0, 1 << N );
        

    }

    static void exploreMap(int r, int c, int width) {
        if (nr == r && nc == c) {
            System.out.println(count);
            return;
        }

        if (r <= nr && r + width > nr && c <= nc && c + width > nc ) {
            exploreMap(r, c, width/2);
            exploreMap(r, c + width / 2, width/2);
            exploreMap(r + width / 2, c, width/2);
            exploreMap(r + width / 2, c + width / 2, width/2);
        } else {
            count += width * width;
        }
    }
}
