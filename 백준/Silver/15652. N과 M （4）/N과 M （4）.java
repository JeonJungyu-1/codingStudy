import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R;
    static int[] nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        nums = new int[R];

        combi(0, 0);

        System.out.println(sb.toString());



    }   

    // 중복 조합
    static void combi(int cnt, int start) {
        if (cnt == R) {
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
                if (i != nums.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            nums[cnt] = i + 1;
            combi(cnt + 1, i);
            nums[cnt] = 0;
        }
    }
}
