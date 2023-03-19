import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비밀번호 발음하기

public class Main {
    private static final String List = null;
    static StringBuilder sb;
    static String vowel = "aeiou";
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
    }

    private static void solve() {
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            char[] ch = str.toCharArray();
            boolean hasVowel = false;
            int vowelCnt = 0;
            int consonantCnt = 0;
            boolean isAccept = true;
            for (int i = 0; i < ch.length; i++) {
                // 모음 하나 포함
                if (!hasVowel && vowel.indexOf(Character.toString(ch[i])) != -1) {
                    hasVowel = true;
                }

                // 모음 3개 혹은 자음 3개
                if (vowel.indexOf(Character.toString(ch[i])) != -1) {
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }
                if (vowelCnt == 3 || consonantCnt == 3) {
                    isAccept = false;
                    break;
                }

                // 같은 글자 연속 / ee, oo는 가능
                if (i != ch.length - 1 && ch[i] == ch[i + 1] && ch[i] != 'e' && ch[i] != 'o') {
                    isAccept = false;
                    break;
                }
            }
            if (!hasVowel) isAccept = false;

            sb.append("<").append(str).append("> is ").append(isAccept ? "" : "not ").append("acceptable.").append("\n");
        }

        System.out.println(sb.toString());


    }
}