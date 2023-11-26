import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 맟추기 게임

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
        StringTokenizer st;
        sb = new StringBuilder();

        
        int i = 1;
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) break;
            int n1 = number * 3;
            int n4 = number / 2;
            sb.append(i).append(". ").append(n1 % 2 == 0 ? "even " : "odd ").append(n4).append("\n");
            i++;
        }

        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}