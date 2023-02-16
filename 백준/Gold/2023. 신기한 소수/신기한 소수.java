import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        perm(0, 0);

        System.out.println(sb.toString());
    }

    private static void perm(int cnt, int currentNum) {
        if (cnt == N) {
            sb.append(currentNum).append("\n");
            return;
        }
        
        for (int i = 0; i < 9; i++) {
            if (!isPrime(currentNum * 10 + i + 1)) continue;
            nums[cnt] = i + 1;
            perm(cnt + 1, currentNum * 10 + nums[cnt]);
            nums[cnt] = 0;
        }
    }

    private static boolean isPrime(int num){
        if (num == 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
