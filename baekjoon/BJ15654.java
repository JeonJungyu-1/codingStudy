package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M 5
// 순열
public class BJ15654 {
    static StringBuilder sb;
    static int N, M;
    static int[] numbers;
    static boolean[] isSelected;
    static int[] selectedNumbers;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < selectedNumbers.length; i++) {
                sb.append(selectedNumbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectedNumbers[cnt] = numbers[i];
            perm(cnt + 1);
            selectedNumbers[cnt] = 0;
            isSelected[i] = false;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        isSelected = new boolean[N];
        selectedNumbers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
