import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 나머지

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            set.add(number % 42);
        }

        System.out.println(set.size());
    }
}