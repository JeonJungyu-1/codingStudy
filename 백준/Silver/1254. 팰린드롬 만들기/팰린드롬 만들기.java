import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 팰린드롬 만들기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();

        int N = ch.length;

        while (true) {
            if (isPalindrome(ch, N)) {
                System.out.println(N);
                break;
            }

            N++;
        }

    }
    private static boolean isPalindrome(char[] ch, int N) {
        int mid = N / 2;
        for (int i = 0; i < mid; i++) {
            if ((N - 1 - i) < ch.length && ch[i] != ch[N - 1 - i]) return false;
        }

        return true;
    }
}