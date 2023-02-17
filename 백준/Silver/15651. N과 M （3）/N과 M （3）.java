import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());    
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        perm(0);

        System.out.println(sb.toString());

    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int num: nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            nums[cnt] = i + 1;
            perm(cnt + 1);
            nums[cnt] = 0;
        } 
    }
}
