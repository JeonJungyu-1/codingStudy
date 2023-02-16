import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] alpha;
    static String[] temp;
    static List<String> check = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        check.add("a");
        check.add("e");
        check.add("i");
        check.add("o");
        check.add("u");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        temp = new String[M];
        alpha = new String[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            alpha[i] = st.nextToken();
        }
        
        Arrays.sort(alpha);

        combi(0, 0);

        System.out.println(sb.toString());


    }

    static void combi(int cnt, int start) {
        if (cnt == M) {
            int chk = 0;
            int chk2 = 0;
            for (int i = 0; i < temp.length; i++) {
                if (check.contains(temp[i])) {
                    chk++;
                } else {
                    chk2++;
                }
            }

            if (chk >= 1 && chk2 >= 2) {
                for (int i = 0; i < temp.length; i++) {
                    sb.append(temp[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < N; i++) {
            temp[cnt] = alpha[i];
            combi(cnt + 1, i + 1);
            temp[cnt] = "";
        }
    }
}
