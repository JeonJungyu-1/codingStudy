import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사과 담기 게임


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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) - 1;

        int J = Integer.parseInt(br.readLine());
        int index = 1;
        int cnt = 0;
        for (int i = 0; i < J; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number < index) {
                cnt += (index - number);
                index = number;
            } else if (number > index + M) {
                cnt += (number - index - M);
                index = number - M;
            }
        }

        System.out.println(cnt);



    }
}