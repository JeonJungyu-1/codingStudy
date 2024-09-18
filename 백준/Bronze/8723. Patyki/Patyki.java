import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Patyki

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

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        if ((numbers[2] * numbers[2]) == (numbers[0] * numbers[0] + numbers[1] * numbers[1])) {
            System.out.println(1);
        } else if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}