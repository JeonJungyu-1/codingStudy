import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Body Mass Index

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


        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        double bmi = weight / (height * height);

        if (bmi > 25) {
            System.out.println("Overweight");
        } else if (bmi >= 18.5)  {
            System.out.println("Normal weight");
        } else {
            System.out.println("Underweight");
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}