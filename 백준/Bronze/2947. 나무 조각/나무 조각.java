import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 조각

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

        int[] number = new int[5];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                if (number[i] > number[i + 1]) {
                    swap(number, i);
                    cnt++;
                    for (int j = 0; j < 5; j++) {
                        sb.append(number[j]).append(" ");
                    }
                    sb.append("\n");
                }
            }

            
            if (cnt == 0) break;

        }
        System.out.println(sb.toString());





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static void swap(int[] number, int i) {
        int temp = number[i];
        number[i] = number[i + 1];
        number[i + 1] = temp;
    }
}