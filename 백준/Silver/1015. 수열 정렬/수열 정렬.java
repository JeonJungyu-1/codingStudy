import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 수열 정렬

public class Main {
    
    static StringBuilder sb;
    static class Number implements Comparable<Number> {
        int index, num;

        public Number(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.num, o.num);
        }

        

        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Number> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Number(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[list.get(i).index] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());



  
    }
}