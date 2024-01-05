import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 역원소 정렬

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
        int n = Integer.parseInt(st.nextToken());
        List<Long> numbers = new ArrayList<>();

        while (true) {
            if (numbers.size() == n) break;
            if (numbers.size() != 0 || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuffer s = new StringBuffer(st.nextToken());
                
                numbers.add(Long.parseLong(s.reverse().toString()));

            }
            

            

        }

        Collections.sort(numbers);

        for (long num : numbers) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}