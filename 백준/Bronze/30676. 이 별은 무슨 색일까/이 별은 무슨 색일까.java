import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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


        int number = Integer.parseInt(br.readLine());

        if (number >= 620) {
            System.out.println("Red");
        } else if (number >= 590) {
            System.out.println("Orange");
        } else if (number >= 570) {
            System.out.println("Yellow");
        } else if (number >= 495) {
            System.out.println("Green");
        } else if (number >= 450) {
            System.out.println("Blue");
        } else if (number >= 425) {
            System.out.println("Indigo");
        } else {
            System.out.println("Violet");
        }



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}