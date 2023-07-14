import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 수열

public class Main {
    
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += numbers[i];
        }
        int max = sum;

        int start = 0;
        int end = K;

        for (int i = 0; i < N - K; i++) {
            sum -= numbers[start];
            sum += numbers[end];
            start++;
            end++;
            max = Math.max(max, sum);
        }

        System.out.println(max);




    }
}