import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달 2
// 그리디

public class Main {
    static Long N;
    static Long minCnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        minCnt = 0L;

        while (true) {
            if (N % 5 == 0) {
                minCnt += N / 5L;
                break;
            }

            N -= 3L;
            minCnt++;
        }

        System.out.println(N < 0L ? -1L :minCnt);


    }
}