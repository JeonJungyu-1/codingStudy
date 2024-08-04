import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// SUAPC 2023 SUMMER

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

    static class Problem {
        int n, p;

        public Problem(int n, int p) {
            this.n = n;
            this.p = p;
        }
        
        
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        List<Problem> list = new ArrayList<>();
        list.add(new Problem(12, 1600));
        list.add(new Problem(11, 894));
        list.add(new Problem(11, 1327));
        list.add(new Problem(10, 1311));
        list.add(new Problem(9, 1004));
        list.add(new Problem(9, 1178));
        list.add(new Problem(9, 1357));
        list.add(new Problem(8, 837));
        list.add(new Problem(7, 1055));
        list.add(new Problem(6, 556));
        list.add(new Problem(6, 773));

        int N = Integer.parseInt(br.readLine());
        Problem result = list.get(N - 1);

        sb.append(result.n).append(" ").append(result.p);
        System.out.println(sb.toString());

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}