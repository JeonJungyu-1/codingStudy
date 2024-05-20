import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 팩토리얼 3

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
        BigInteger result = fact2(1, N);
        System.out.println(result.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    public static BigInteger fact(int a, int n) {
        if (a == n) {
            return BigInteger.valueOf(a);
        }

        int mid = (a + n) / 2;
        return fact(a, mid).multiply(fact(mid + 1, n));
    }

    public static BigInteger fact2(int a, int n) {
		
		BigInteger mul = BigInteger.valueOf(a);
		
		if(a < n) {
			int b = (a + n) / 2;
			mul = fact(a, b).multiply(fact(b + 1, n));
		}
		
		return mul;
	}
}