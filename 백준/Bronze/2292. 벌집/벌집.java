import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벌집
// 1 6 12 18 24
// 1 7 19 37 61

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int multi = 6;
        int sum = 1;
        int cnt = 1;
        while (true) {

            if (N <= sum) break;

            sum += multi;
            multi += 6;
            cnt++;

        }

        System.out.println(cnt);


    }
}