import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16진수

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
        int mul = 1;
        int sum = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] >= 48 && ch[i] <= 57) {
                sum += (mul * (ch[i] - 48));
            } else {
                sum += (mul * (ch[i] - 55));
            }   

            mul *= 16;
        }


        System.out.println(sum);

 
    }
}