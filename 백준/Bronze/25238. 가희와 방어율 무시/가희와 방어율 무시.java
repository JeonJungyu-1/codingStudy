import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가희와 방어율 무시

public class Main {
    static StringBuilder sb;
    static double a, b, result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(result >= 100 ? 0 : 1);
    }

    private static void solve() {
        result = (a * (100 - b))/100;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());
    }
}