import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 곱셈

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] first = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                first[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] second = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                second[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] newArray = new int[N][C];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                
                for (int k = 0; k < M; k++) {
                    newArray[i][j] += (first[i][k] * second[k][j]);
                }


            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(newArray[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());




    }
}