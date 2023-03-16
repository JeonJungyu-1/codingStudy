import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < string.length - word.length + 1; i++) {

            if (string[i] == word[0]) {
                for (int j = 0; j < word.length; j++) {
                    if (string[i + j] != word[j]) break;

                    if (j == word.length - 1) {
                        i += word.length - 1;
                        cnt++;
                    }
                }
            }

        }

        System.out.println(cnt);
    }
}