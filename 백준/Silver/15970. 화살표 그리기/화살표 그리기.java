import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 화살표 그리기

public class Main {
    
    static StringBuilder sb;
    static int N;
    static List<Integer>[] number;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        int result = 0;
        for (int i = 1; i <= N; i++) {

            for (int j = 0; j < number[i].size(); j++) {
                if (j == 0) {
                    result += (number[i].get(j + 1) - number[i].get(j));
                } else if (j == number[i].size() - 1) {
                    result += (number[i].get(j) - number[i].get(j - 1));
                } else {
                    int before = number[i].get(j) - number[i].get(j - 1);
                    int after = number[i].get(j + 1) - number[i].get(j);
    
                    result += (before < after ? before : after);

                }
            }

        }

        System.out.println(result);

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        number = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            number[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            number[color].add(location);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(number[i]);
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}