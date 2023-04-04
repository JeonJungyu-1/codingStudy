import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 광고
// kmp

public class Main {
    static int N;
    static String str;
    static int minLength;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        char[] pattern = str.toCharArray();

        int pLength = pattern.length;

        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        sb.append(pLength - pi[pLength - 1]);
        
        System.out.println(sb.toString());
    }
    
}