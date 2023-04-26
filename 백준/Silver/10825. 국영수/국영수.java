import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 국영수

public class Main {

    static int N;
    static class Score implements Comparable<Score> {
        String n;
        int k, m, e;
        public Score(String n, int k, int m, int e) {
            this.n = n;
            this.k = k;
            this.m = m;
            this.e = e;
        }

        @Override
        public int compareTo(Score o) {
            int compareKorean = -Integer.compare(this.k, o.k);
            int compareEnglish = Integer.compare(this.e, o.e);
            int compareMath = -Integer.compare(this.m, o.m);
            int compareName = this.n.compareTo(o.n);
            return compareKorean != 0 ? compareKorean : compareEnglish != 0 ? compareEnglish : compareMath != 0 ? compareMath : compareName;
        }

        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Score> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.add(new Score(n, k, m, e));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Score s : list) {
            sb.append(s.n).append("\n");
        }

        System.out.println(sb.toString());

        
    }
}