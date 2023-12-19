import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마이크로소프트 로고

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



        sb.append("       _.-;;-._\n'-..-'|   ||   |\n'-..-'|_.-;;-._|\n'-..-'|   ||   |\n'-..-'|_.-''-._|");
        System.out.println(sb.toString());
    }
}