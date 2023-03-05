package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 종이 자르기

public class BJ2628 {
    static StringBuilder sb;
    static int N, M;
    static List<Integer> row, column;
    static int maxRow, maxColumn;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(maxRow * maxColumn);
    }

    private static void solve() {
        Collections.sort(row);
        Collections.sort(column);
        maxRow = Integer.MIN_VALUE;
        maxColumn = Integer.MIN_VALUE;
        for (int i = 1; i < row.size(); i++) {
            maxRow = Math.max(maxRow, row.get(i) - row.get(i - 1));
        }

        for (int i = 1; i < column.size(); i++) {
            maxColumn = Math.max(maxColumn, column.get(i) - column.get(i - 1));
        }



    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        row = new ArrayList<>();
        column = new ArrayList<>();

        int K = Integer.parseInt(br.readLine());
        row.add(0);
        column.add(0);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) {
                row.add(Integer.parseInt(st.nextToken()));
            } else {
                column.add(Integer.parseInt(st.nextToken()));
            }
        }
        row.add(N);
        column.add(M);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
