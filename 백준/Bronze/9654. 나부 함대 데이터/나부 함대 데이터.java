import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나부 함대 데이터

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


        System.out.println("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n" + //
                        "N2 Bomber      Heavy Fighter  Limited    21        \n" + //
                        "J-Type 327     Light Combat   Unlimited  1         \n" + //
                        "NX Cruiser     Medium Fighter Limited    18        \n" + //
                        "N1 Starfighter Medium Fighter Unlimited  25        \n" + //
                        "Royal Cruiser  Light Combat   Limited    4         ");



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}