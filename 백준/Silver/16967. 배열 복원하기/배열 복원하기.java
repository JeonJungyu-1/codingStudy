import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 복원하기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        int[][] numbers = new int[H + X][W + Y];
        for (int i = 0; i < numbers.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i - X >= 0 && j - Y >= 0) {
                    result[i][j] = numbers[i][j] - result[i - X][j - Y];
                } else {
                    result[i][j] = numbers[i][j];
                }
            }
        }
        


      

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }
}