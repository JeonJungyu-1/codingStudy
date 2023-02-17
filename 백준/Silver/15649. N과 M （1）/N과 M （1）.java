import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nums = new int[M];

        perm(0);
        System.out.println(sb.toString());
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
                if (i != nums.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            nums[cnt] = i + 1;
            perm(cnt + 1);
            nums[cnt] = 0;
            visited[i] = false;

        }

    }
}
