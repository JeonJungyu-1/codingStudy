
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int row = Integer.parseInt(st[0]);
        int column = Integer.parseInt(st[1]);
        map = new String[row][column];

        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().split("");
        }


        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= column - 8; j++) {
                min = Math.min(min, Math.min(blackStartCheck(i, j), whiteStartCheck(i, j)));
            }
        }


        System.out.println(min);



    }

    static int commonMapCheck(int r, int c, String firstStr, String secondStr) {
        int count = 0;
        String color;
        for (int i = r; i < r + 8; i++) {
            color = (i - r) % 2 == 0 ? firstStr : secondStr;
            for (int j = c; j < c + 8; j++) {
                if ((j - c) % 2 == 0 && !map[i][j].equals(color)) {
                    count++;
                } else if ((j - c) % 2 == 1 && map[i][j].equals(color)) {
                    count++;
                }
            }
        }
        return count;
    }

    static int blackStartCheck(int r, int c) {
        return commonMapCheck(r, c, "B", "W");
    }

    static int whiteStartCheck(int r, int c) {
        return commonMapCheck(r, c, "W", "B");
    }
}
