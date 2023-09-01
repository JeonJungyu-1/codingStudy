import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음계

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int result = 0;
        if (start == 1) {
            result = 0;
            for (int i = 0; i < 7; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (number != start + 1) {
                    result = 2;
                    break;
                }
                start = number;
            }
        } else {
            result = 1;
            for (int i = 0; i < 7; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (number != start - 1) {
                    result = 2;
                    break;
                }
                start = number;
            }
        }

        System.out.println(result == 0 ? "ascending" : result == 1 ? "descending" : "mixed");

    }
}