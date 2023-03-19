import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 등수 구하기

public class Main {
    static StringBuilder sb;
    static int N, newScore, P;
    static List<Integer> scores;
    static int rank;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(rank);
    }

    private static void solve() {
        scores.add(newScore);
        Collections.sort(scores, Collections.reverseOrder());
        rank = 1;
        if (N == P && newScore <= scores.get(scores.size() - 1)) {
            rank = -1;
            return;
        }

        if (N == 0) {
            rank = 1;
            return;
        }
        int cnt = 0;
        for (int i = 0; i < scores.size() - 1; i++) {
            if (newScore == scores.get(i)) break;

            if (scores.get(i) != scores.get(i + 1)) {
                rank++;
                rank += cnt;
                cnt = 0;
            } else {
                cnt++;
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        scores = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        newScore= Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (N == 0) return;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }



    }
}