import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (true) {
            if (N % 5 == 0) {
                cnt += N/5;
                break;
            }
            N -= 3;
            cnt++;
        }
        
        if (N < 0) {
            cnt = -1;
        }
        System.out.println(cnt);
    }
}