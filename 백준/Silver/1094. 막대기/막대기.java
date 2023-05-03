import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 막대기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
  

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int number = 64;
        int count = 0;

        while (number > 0) {
            if ((X & number) != 0) {
                count++;
            }
            number /= 2;
        }

        System.out.println(count); 
    }
}