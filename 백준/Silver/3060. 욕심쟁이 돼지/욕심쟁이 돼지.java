import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 욕심쟁이 돼지

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


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] pig = new int[6];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                pig[i] = Integer.parseInt(st.nextToken());
            }

            int d = 1;
            long currentN = N;

            int[] currentPig = new int[6];

            for (int i = 0; i < 6; i++) {
                currentN -= pig[i];
                currentPig[i] = pig[i];
            }



            
            while (true) {
                if (currentN < 0) break;
                d++;
                currentN = N;

                

                for (int i = 0; i < 6; i++) {
                        int across = i < 3 ? i + 3 : i - 3;
                        int before = (i + 1) % 6;
                        int after = (i + 5) % 6;
                        currentN -= currentPig[i];
                        currentN -= currentPig[across];
                        currentN -= currentPig[before];
                        currentN -= currentPig[after];

                        pig[i] = currentPig[i] + currentPig[across] + currentPig[before] + currentPig[after];
                }
                currentPig = Arrays.copyOf(pig, 6);

            }

            sb.append(d).append("\n");

        }

        System.out.println(sb.toString());


        




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}