package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 타노스

public class BJ20310 {
    static StringBuilder sb;
    static String S;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    


    private static void solve() {
        String zeroStr = S.replace("1", "");
        int zero = zeroStr.length();
        int one = S.length() - zero;

        zero /= 2;
        one /= 2;

        String[] strArr = S.split("");

        for (int i = 0; i < strArr.length; i++) {
            if (one == 0) {
                break;
            } else if (strArr[i].equals("1")) {
                strArr[i] = "";
                one--;
            }
        }

        for (int i = strArr.length -1; i >= 0; i--) {
            if (zero == 0) {
                break;
            } else if (strArr[i].equals("0")) {
                strArr[i] = "";
                zero--;
            }
        }


        String newStr = String.join("", strArr);

        System.out.println(newStr);
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        S = br.readLine();



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
