import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 알파벳 찾기


public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();
        int[] indexList = new int[26];
        Arrays.fill(indexList, -1);

        for (int i = 0; i < ch.length; i++) {
            if (indexList[ch[i] - 97] == -1) {
                indexList[ch[i] - 97] = i;
            }
        }

        for (int i = 0; i < indexList.length; i++) {
            sb.append(indexList[i]).append(" ");
        }

        System.out.println(sb.toString());

    }
}