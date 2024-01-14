import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 뒤집어진 소수

public class Main {
    
    static StringBuilder sb;
    static char[] number;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();

        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] == '3' || number[i] == '4' || number[i] == '7') {
                System.out.println("no");
                return;
            } else if (number[i] == '6') {
                sb.append(9);
            } else if (number[i] == '9') {
                sb.append(6);
            } else {
                sb.append(number[i]);
            }
        }

        long inputNumber = Long.parseLong(new String(number));
        long reverseNumber = Long.parseLong(sb.toString());


        if (isPrime(reverseNumber) && isPrime(inputNumber)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        print();
    }

    private static boolean isPrime(long num) {
        if (num == 1) return false;

        long sqrt = (long)Math.sqrt(num);

        for (long i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }


        return true;

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        number = br.readLine().toCharArray();






        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}