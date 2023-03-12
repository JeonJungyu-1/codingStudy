package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// IF문 좀 대신 써줘
// 이분 탐색

public class BJ19637 {
    static StringBuilder sb;
    static int N, M;
    static Style[] list;

    static class Style {
        String name;
        int number;
        public Style(String name, int number) {
            this.name = name;
            this.number = number;
        }
        
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        list = new Style[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            list[i] = new Style(name, number);
        }

        for (int i = 0; i < M; i++) {
            int current = Integer.parseInt(br.readLine());
            int low = -1;
            int high = N;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                if (list[mid].number < current) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            sb.append(list[high].name).append("\n");
        }

        System.out.println(sb.toString());





    }
}
