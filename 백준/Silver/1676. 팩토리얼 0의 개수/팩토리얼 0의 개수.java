import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팩토리얼 0의 개수

public class Main {
    
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();

        int cnt = 0;
        while (5 <= N) {
            N /= 5;
            cnt += N;
        }   
        System.out.println(cnt);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());


    }
}