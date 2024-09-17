import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Sounds fishy!

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

        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int up = 0;
        int down = 0;
        int same = 0;

        for (int i = 0; i < 3; i++) {
            if (numbers[i] < numbers[i + 1]) {
                up++;
            } else if (numbers[i] == numbers[i + 1]) {
                same++;
            } else {
                down++;
            }
        }

        if (up == 3) {
            System.out.println("Fish Rising");
        } else if (down == 3) {
            System.out.println("Fish Diving");
        } else if (same == 3) {
            System.out.println("Fish At Constant Depth");
        } else {
            System.out.println("No Fish");
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}