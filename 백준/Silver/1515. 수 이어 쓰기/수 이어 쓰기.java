import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수 이어 쓰기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        char[] number = br.readLine().toCharArray();
        int N = 0;

        for (int i = 0; i < number.length; i++) {
            N++;
            char[] ch = String.valueOf(N).toCharArray();
            int cnt = 0;
            for (int j = 0; j < ch.length; j++) {
                if (i >= number.length) {
                    if (cnt == 0) N--;
                    break;
                }
                if (number[i] == ch[j]) {
                    cnt++;
                    i++;
                }
            }
            i--;
        }


        System.out.println(N);


    }
}