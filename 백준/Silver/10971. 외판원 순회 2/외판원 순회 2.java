import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] isVisited;
    static int[] city;
    static int N;
    static int minPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];
        city = new int[N];
        minPrice = Integer.MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);

        System.out.println(minPrice);

        
    }

    static void combi(int cnt, int price) {
        if (cnt == N) {
            if (map[city[cnt - 1]][city[0]] == 0) return;
            price += map[city[cnt - 1]][city[0]];

            minPrice = Math.min(price, minPrice);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            city[cnt] = i;

            if (cnt != 0) {
                if (map[city[cnt - 1]][city[cnt]] == 0) {
                    isVisited[i] = false;
                    continue;
                }
                combi(cnt + 1, price + map[city[cnt - 1]][city[cnt]]);
            } else {
                combi(cnt + 1, price);
            }
            city[cnt] = 0;
            isVisited[i] = false;

        } 
    }

}

