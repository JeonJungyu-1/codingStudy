import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 학생 번호

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

        String[] numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }


        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = numbers[0].length() - 1; i >= 0; i--) {
            cnt++;
            
            for (int j = 0; j < numbers.length; j++) {
                set.add(numbers[j].substring(i));
            }
            if (set.size() == numbers.length) {

                break;
            }
            set.clear();

        }

        System.out.println(cnt);
    }
}