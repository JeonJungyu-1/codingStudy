import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 성적 통계

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int t = 1; t <= T; t++) {
            list.clear();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            int maxGap = Integer.MIN_VALUE;
            for (int i = 0; i < N - 1; i++) {
                maxGap = Math.max(list.get(i + 1) - list.get(i), maxGap);
            }

            sb.append("Class ").append(t).append("\n");
            sb.append("Max ").append(list.get(N - 1)).append(", Min ").append(list.get(0)).append(", Largest gap ").append(maxGap).append("\n");



        }

        System.out.println(sb.toString());
    }
}