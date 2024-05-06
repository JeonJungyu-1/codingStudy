import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 임시 반장 정하기

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

        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Set<Integer>[] set = new HashSet[N];
        for (int j = 0; j < N; j++) {
            set[j] = new HashSet<>();
        }
        
        for (int i = 0; i < 5; i++) {


            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (numbers[j][i] == numbers[k][i]) {
                        set[j].add(k);
                        set[k].add(j);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (set[i].size() > max) {
                max = set[i].size();
                maxIndex = i + 1;
            }
        }

        System.out.println(maxIndex);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}