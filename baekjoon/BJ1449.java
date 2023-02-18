package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


// 수리공 항승 - 그리디
// 오름차순 정렬
// 테이프 붙이기 시작하는 위치를 기준으로 하고, 
// 그 위치를 빼주었을 때 값이 테이프 길이보다 작으면 붙이는거 가능함.
public class BJ1449 {
    static int N, L;
    static int[] hole;
    static StringBuilder sb;
    static int cnt;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        sb.append(cnt);
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        Arrays.sort(hole);
        cnt = 1;
        int first = hole[0];
        for (int i = 1; i < hole.length; i++) {
            if (hole[i] - first >= L) {
                first = hole[i];
                cnt++;
            }
        }

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        hole = new int[N];
        for (int i = 0; i < N; i++) {
            hole[i] = Integer.parseInt(st.nextToken());
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
