package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10994 {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //맵 생성 후 0으로 채워넣기
        map = new int[num * 4 - 3 ][num * 4 - 3];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

        // 초기좌표하고 받은 네모 단계 넣어서 star 호출
        star(0, 0, num);

        // 맵에 들어있는 값들을 스트링빌더에 추가
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int r, int c, int n) {
        // 그릴 수 없는 네모가 없을 때 return
        if (n == 0) return;

        // 한단계 작은 네모 그리기
        star(r + 2, c + 2, n - 1);

        // 네모 부분을 1로 바꾸기
        int size = n * 4 - 3;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i == r || i == r + size - 1) {
                    map[i][j] = 1;
                } else {
                    if (j == c || j == c + size - 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        

    }
}
