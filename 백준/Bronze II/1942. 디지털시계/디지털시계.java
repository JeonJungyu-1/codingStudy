import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 디지털 시게

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

        for (int t = 0; t < 3; t++) {

            st = new StringTokenizer(br.readLine());

            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");
            int cnt = 0;
            while (true) {
                int number = Integer.parseInt(start[0] + start[1] + start[2]);
                if (number % 3 == 0) cnt++;
                if (start[0].equals(end[0]) && start[1].equals(end[1]) && start[2].equals(end[2])) break;
                start[2] = String.valueOf(Integer.parseInt(start[2]) + 1);
                if (start[2].length() == 1) start[2] = "0" +start[2];
                if (start[2].equals("60")) {
                    start[2] = "00";
                    start[1] = String.valueOf(Integer.parseInt(start[1]) + 1);
                    if (start[1].length() == 1) start[1] = "0" +start[1];

                }
                if (start[1].equals("60")) {
                    start[1] = "00";
                    start[0] = String.valueOf(Integer.parseInt(start[0]) + 1);
                    if (start[0].length() == 1) start[0] = "0" +start[0];

                }
                if (start[0].equals("24")) {
                    start[0] = "00";
                }
            }
            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}