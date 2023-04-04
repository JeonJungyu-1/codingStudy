import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 찾기
// kmp

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLength = text.length;
        int pLength = pattern.length;

        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    cnt++;
                    list.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        if (cnt > 0) {
            for (int index : list) {
                sb.append(index).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}