import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전구

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] number = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    number[a] = b;
                    break;
                case 2:
                    for (int j = a; j <= b; j++) {
                        number[j] = (number[j] + 1) % 2;
                    }
                    break;
                case 3:
                    for (int j = a; j <= b; j++) {
                        number[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = a; j <= b; j++) {
                        number[j] = 1;
                    }
                    break;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(number[i]).append(" ");
        }

        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}