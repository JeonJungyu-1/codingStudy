import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

// 오늘의 날짜는?

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
        Calendar cal=Calendar.getInstance();

        System.out.println(cal.get(Calendar.YEAR));

        System.out.println(cal.get(Calendar.MONTH) + 1);        
        System.out.println(cal.get(Calendar.DATE));


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}