import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 그룹 단어 체커

public class Main {
    
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        solve();
    }
  

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        boolean[] isCheck = new boolean[26];
        N = Integer.parseInt(br.readLine());
        int cnt = 0;

        outer:
        for (int i = 0; i < N; i++) {
            Arrays.fill(isCheck, false);
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (isCheck[ch[j] - 97]) {
                    continue outer;
                } else if (j != ch.length - 1 && ch[j] != ch[j + 1]) {
                    isCheck[ch[j] - 97] = true;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
  
    }
}