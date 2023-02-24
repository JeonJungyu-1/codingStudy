import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers;
    static int N;
    static int bitMasking;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        print();
    }
    private static void print() {
        System.out.println(sb.toString());
    }
    private static void solve(String command, int num) {
        
        switch (command) {
            case "add" :
                add(num);
                break;

            case "remove" :
                remove(num);
                break;

            case "check" :
                if (check(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;

            case "toggle" :
                toggle(num);
                break;

            case "all" :
                all();
                break;

            case "empty" :
                empty();
                break;

        }

        
    }
    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[21];
        for (int i = 0; i < 21; i++) {
            numbers[i] = 20 - i;
        }
        bitMasking = 0;
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                solve(command, num);
            } else {
                solve(command, 0);
            }

        }
    }

    private static void add(int i) {
        bitMasking = bitMasking | (1 << i);
    }
    private static void remove(int i) {
        bitMasking = bitMasking & ~(1 << i);
        
    }
    private static boolean check(int i) {
        if ((bitMasking & 1 << i) == 1 << i) return true;
        else return false;
    }
    private static void toggle(int i) {
        bitMasking = bitMasking ^ (1 << i);

    }
    private static void all() {
        bitMasking |= (1 << 22) - 1;
    }
    private static void empty() {
        bitMasking = 0;
    }
}