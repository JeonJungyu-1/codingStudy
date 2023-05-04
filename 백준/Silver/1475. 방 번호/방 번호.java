import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 방번호

public class Main {
    
    static StringBuilder sb;
    static int[] number;
    public static void main(String[] args) throws IOException {
        solve();
    }
 

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        number = new int[10];
        char[] ch = br.readLine().toCharArray();

        for (char c : ch) {
            number[c - '0']++;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 6:
                case 9:
                    result = Math.max(result, (number[9] + number[6] - 1)/2 + 1);
                    break;
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    result = Math.max(result, number[i]);
                    
                    break;

            }
        }

        System.out.println(result);
    }
}