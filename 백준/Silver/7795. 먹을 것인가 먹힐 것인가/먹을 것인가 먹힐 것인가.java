import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가

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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(A);
            Collections.sort(B);

            int count = 0;

            int i = 0;
            int j = 0;

            while (i < N) {
                if (A.get(i) > B.get(j)) {
                    if (j < M - 1) {
                        j++;
                    } else {
                        count += j + 1;
                        i++;
                    }
                } else {
                    count += j;
                    i++;
                }
            }

            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < M; j++) {
            //         if (A.get(i) <= B.get(j)) break;
            //         count++;
            //     }
            // }

            sb.append(count).append("\n");

        }


        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}