package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ10431 {
    static StringBuilder sb;
    static int T;
    static int[] students;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static int solve() {
        int cnt = 0;

        list.add(students[0]);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > students[i]) {
                    list.add(j, students[i]);
                    cnt += (i - j);
                    break;
                } else if (students[i] != list.get(j) && j == list.size() - 1) {
                    list.add(students[i]);
                    j++;
                }
            }
            // System.out.println(cnt);
            // System.out.println(list);
        }



        return cnt;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            students = new int[20];
            list = new ArrayList<>();
            st.nextToken();
            for (int i = 0 ; i < 20; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            int result = solve();
            sb.append(t).append(" ").append(result).append("\n");
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
