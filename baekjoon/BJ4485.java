package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
// 한칸마다 좌우 최대값을 찾음
// 그중 작은값보다 현재 높이가 낮다면 그 차이 만큼 빗물이 고임
public class BJ4485 {
    static StringBuilder sb;
    static int N, M;
    static int[] block;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
    }

    private static void solve() {
        int result = 0;

        for (int i = 0; i < block.length; i++) {
            int secondMax = Math.min(searchLeftMax(i), searchRightMax(i));
            if (block[i] < secondMax) result += (secondMax - block[i]);
        }

        System.out.println(result);

    }

    private static int searchLeftMax(int index) {
        int max = -1;
        for (int i = 0; i < index; i++) {
            if (block[i] > max) max = block[i];
        }
        return max;
    }
    private static int searchRightMax(int index) {
        int max = -1;
        for (int i = index + 1; i < block.length; i++) {
            if (block[i] > max) max = block[i];
        }
        return max;

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        block = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }






        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
