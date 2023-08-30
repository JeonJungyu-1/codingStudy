import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오늘도 졌다

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int[] A = new int[9];
        int[] B = new int[9];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int aScore = 0;
        int bScore = 0;

        boolean isAwin = false;


        for (int i = 0; i < 9; i++) {
            aScore += A[i];
            if (aScore > bScore) {
                isAwin = true;
            }
            bScore += B[i];
        }

        System.out.println(aScore < bScore && isAwin ? "Yes" : "No");

    }
}