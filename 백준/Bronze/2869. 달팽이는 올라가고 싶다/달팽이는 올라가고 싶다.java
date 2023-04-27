import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다

public class Main {
    
    static StringBuilder sb;
    static int A, B, V;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(int result) {
        System.out.println(result);
    }

    private static void solve() throws IOException {
        init();
        int day = 0;
        if (A == V) {
            day = 1;
        } else {
            day = ((V - A - 1) / (A - B)) + 2;
        }
        print(day);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
  
    }
}