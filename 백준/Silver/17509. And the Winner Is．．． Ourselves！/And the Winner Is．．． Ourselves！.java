import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// And the Winner Is... Ourselves! - 그리디 알고리즘
// 시간값을 오름차순으로 정렬하고 차례대로 계산
// V값은 시간과 무관하게 고정되기 떄문에 신경 안써도 됨
public class Main {
    static StringBuilder sb;
    static List<Score> list;
    static int sum;
    static int time;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sum);
    }

    private static void solve() {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Score score = list.get(i);
            time += score.t;
            sum += time + score.v * 20;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        list = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        br.close();
    }

    static class Score implements Comparable<Score> {
        int t;
        int v;
        public Score(int t, int v) {
            this.t = t;
            this.v = v;
        }
        @Override
        public String toString() {
            return "Score [t=" + t + ", v=" + v + "]";
        }
        @Override
        public int compareTo(Score o) {
            return Integer.compare(this.t, o.t);
        }
        
        
    }
}