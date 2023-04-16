import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// IOIOI

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static String str;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
   

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();

        // StringBuilder replaceStr = new StringBuilder();
        // for (int i = 0; i < N; i++) {
        //     replaceStr.append("IO");
        // }
        // replaceStr.append("I");
        

        

        int result = 0;
        int index = 0;
        String changeStr = "IO".repeat(N) + "I";
        while (true) {
            index = str.indexOf(changeStr, index);
            if (index == -1) {
                break;
            } else {
                result++;
                index += 2;
            }
        }

        System.out.println(result);





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}