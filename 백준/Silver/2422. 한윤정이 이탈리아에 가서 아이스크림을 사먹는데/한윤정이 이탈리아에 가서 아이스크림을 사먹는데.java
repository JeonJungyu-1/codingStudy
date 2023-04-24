import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한윤정이 이탈리아에 가서 아이스크림을 사먹는데

public class Main {
    static int N, M;
    static boolean[][] adj;
    static int[] selected;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());        
        M = Integer.parseInt(st.nextToken());
        
        adj = new boolean[201][201];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s][e] = true;
            adj[e][s] = true;
        }
        selected = new int[3];

        combination(0, 0);

        System.out.println(count);



    }
    private static void combination(int cnt, int start) {
        if (cnt == 3) {
            if (isAvailable()) {
                count++;
            }
            return;
        }



        for (int i = start; i < N; i++) {
            selected[cnt] = i + 1;
            combination(cnt + 1, i + 1);
        }
    }
    private static boolean isAvailable() {

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (adj[selected[i]][selected[j]]) {
                    return false;
                }
            }
        }

        return true;
    }
}