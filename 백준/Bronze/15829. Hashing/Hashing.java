import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Hashing

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
        char[] ch = br.readLine().toCharArray();

        int result = 0;
        int multi = 1;
        for (int i = 0; i < N; i++) {
            result += ((ch[i] - 96) * multi) % 1234567891;
            multi *= 31;
        }

        System.out.println(result);
    }
}